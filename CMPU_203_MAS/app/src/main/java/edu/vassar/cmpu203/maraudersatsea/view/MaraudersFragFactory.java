package edu.vassar.cmpu203.maraudersatsea.view;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import edu.vassar.cmpu203.maraudersatsea.controller.MainActivity;


public class MaraudersFragFactory extends FragmentFactory {

    private static final String VIEW_PACKAGE = MaraudersFragFactory.class.getPackage().getName(); // package where all all fragments reside
    private final MainActivity controller; // the controller instance to pass to fragments

    /**
     * Constructor method.
     * @param controller the activity to pass in to fragments
     */
    public MaraudersFragFactory(MainActivity controller){
        this.controller = controller;
    }

    /**
     * Method used by fragment manager/transaction to instantiate fragments.
     * @param classLoader object to use to load fragment class
     * @param className name of fragment class to instantiate
     * @return instantiated fragment
     */
    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {

        // convert from class name to class
        Class<? extends Fragment> fragClass = loadFragmentClass(classLoader, className);

        // is this fragment in our view package? if so, it must be one of ours!
        if (fragClass.getPackage().getName().equals(VIEW_PACKAGE)) {
            try {
                Constructor<?>[] fcons = fragClass.getConstructors(); // get all the constructors
                assert fcons.length > 0 : "Fragment class does not have a constructor";
                return (Fragment) fcons[0].newInstance(controller); // go with first constructor
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                final String emsg = String.format("Can't instantiate %s: ensure it's concrete and " +
                        "has a public constructor with a ControllerActivity parameter", fragClass);
                Log.e("Marauders", emsg);
                e.printStackTrace();
            }
        }

        // default is to delegate to superclass
        return super.instantiate(classLoader, className);
    }
}
