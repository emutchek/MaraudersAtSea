package edu.vassar.cmpu203.maraudersatsea;
import android.view.View;

import edu.vassar.cmpu203.maraudersatsea.controller.MainActivity;
import edu.vassar.cmpu203.maraudersatsea.model.Library;

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
public class ResourceAreaFragmentTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @org.junit.Test
    /**
     * Testing picking up a resource. navigates to the first resource area, which is two moves
     * from the first island. Verifies the messages that are shown and simulates clicking the
     * pick up button. Also verifies that the inventory gets updated when the resource is picked
     * up.
     * Issues: Can't click exit button. Assumes inventory is not full.
     */
    public void testPickUp(){
        Library lib = new Library();
        lib.setIslands();
        Matcher<View> matcher = ViewMatchers.withId(R.id.RAfound);
        ViewInteraction RAView = Espresso.onView(matcher);
        Espresso.onView(ViewMatchers.withId(R.id.playButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.moveButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.storyOptionA)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.exitButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.moveButton)).perform(ViewActions.click());
        //now a resource area with description of medicine has appeared
        //inventory is not full
        RAView.check(ViewAssertions.matches(ViewMatchers.withText("Oh look! Some medicine. Do you want to grab it? (Q)")));
        Espresso.onView(ViewMatchers.withId(R.id.grabRA)).perform(ViewActions.click());
        RAView.check(ViewAssertions.matches(ViewMatchers.withText(R.string.RAPickedUp)));
        Matcher<View> matcher2 = ViewMatchers.withId(R.id.inventory);
        ViewInteraction RAView2 = Espresso.onView(matcher2);
        RAView2.check(ViewAssertions.matches(ViewMatchers.withText("INVENTORY: \nRope: 20 spools\nWood: 20 logs\nMedicine: 30 vials")));
        Espresso.onView(ViewMatchers.withId(R.id.exitRA)).perform(ViewActions.click());

    }

}