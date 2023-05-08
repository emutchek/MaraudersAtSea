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
public class ObstacleViewFragmentTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @org.junit.Test
    /**
     *
     */
    public void testPickUp(){
        Library lib = new Library();
        lib.setIslands();
        Matcher<View> matcher = ViewMatchers.withId(R.id.obstacleText);
        ViewInteraction ObsView = Espresso.onView(matcher);
        Espresso.onView(ViewMatchers.withId(R.id.playButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.moveButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.storyOptionA)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.exitButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.moveButton)).perform(ViewActions.click());
        ObsView.check(ViewAssertions.matches(ViewMatchers.withText("☠ PLAGUE ALERT ☠" +
                "\nMeels woke up this morning covered in boils. We must have incurred the wrath of " +
                "an angry spirit... or maybe it was the brownish drinking water. What do you do?")));
        Espresso.onView(ViewMatchers.withId(R.id.storyOptionA)).perform(ViewActions.click());
        ObsView.check(ViewAssertions.matches(ViewMatchers.withText("Now everyone's sick and there's no one to get fresh water! (-25 HEALTH)")));

    }

}