package edu.vassar.cmpu203.maraudersatsea.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import edu.vassar.cmpu203.maraudersatsea.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.maraudersatsea.databinding.FragmentGridViewBinding;

/**
 * An implementation of the application's screen template.
 */
public class MainView implements IMainView{

    FragmentManager fmanager; // lets us perform fragment transactions
    ActivityMainBinding binding;  // gives us access to all the graphical components in res/layout/main.xml

    /**
     * Constructor method.
     * @param activity The android activity the screen is associated with.
     */
    public MainView(FragmentActivity activity){
        this.fmanager = activity.getSupportFragmentManager();
        this.binding = ActivityMainBinding.inflate(activity.getLayoutInflater());
    }

    /**
     * Retrieve the graphical widget (android view) at the root of the screen hierarchy/
     * @return the screen's root android view (widget)
     */
    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }

    /**
     * Replaces the contents of the screen's fragment container with the one passed in as an argument.
     *
     * @param fragment The fragment to be displayed.
     * @param reversible true if this transaction should be reversible, false otherwise
     * @param name the name this transaction can be referred by.
     */
    @Override
    public void displayFragment(Fragment fragment, boolean reversible, String name) {
        FragmentTransaction ft = fmanager.beginTransaction()
                .replace(this.binding.fragmentContainerView.getId(), fragment);

        if (reversible) ft.addToBackStack(name);
        ft.commit(); // execute transaction
    }
}

