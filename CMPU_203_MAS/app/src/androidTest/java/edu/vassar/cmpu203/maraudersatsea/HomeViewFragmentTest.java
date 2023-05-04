package edu.vassar.cmpu203.maraudersatsea;
import edu.vassar.cmpu203.maraudersatsea.controller.MainActivity;
import edu.vassar.cmpu203.maraudersatsea.model.Library;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.hamcrest.Matcher;
import org.junit.runner.RunWith;
//import static org.junit.jupiter.api.Assertions.*;

@RunWith(AndroidJUnit4.class)
public class HomeViewFragmentTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @org.junit.Test
    public void testRead(){
        Matcher<View> matcher = ViewMatchers.withId(R.id.welcomeMessage);
        ViewInteraction homeVi = Espresso.onView(matcher);
        homeVi.check(ViewAssertions.matches(ViewMatchers.withText(R.string.welcome)));

        Espresso.onView(ViewMatchers.withId(R.id.playButton)).perform(ViewActions.click());

    }

}