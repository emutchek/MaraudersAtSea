package edu.vassar.cmpu203.maraudersatsea;
import edu.vassar.cmpu203.maraudersatsea.controller.MainActivity;

import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;
//import static org.junit.jupiter.api.Assertions.*;

@RunWith(AndroidJUnit4.class)
public class MapViewFragmentTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @org.junit.Test
    public void testRead(){
        Matcher<View> matcher = ViewMatchers.withId(R.id.mapImage);
        ViewInteraction mapVi = Espresso.onView(matcher);

        Espresso.onView(ViewMatchers.withId(R.id.playButton)).perform(ViewActions.click());

        //check map before ship has moved
        Espresso.onView(ViewMatchers.withId(R.id.mapButton)).perform(ViewActions.click());
        mapVi.check(ViewAssertions.matches(ViewMatchers
                .withTagValue(Matchers.equalTo(R.drawable.kraken))));

        //check map after visiting first island
        Espresso.onView(ViewMatchers.withId(R.id.exitButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.moveButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.storyOptionA)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.exitButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.mapButton)).perform(ViewActions.click());
        mapVi.check(ViewAssertions.matches(ViewMatchers
                .withTagValue(Matchers.equalTo(R.drawable.smallbarrel))));
    }
}