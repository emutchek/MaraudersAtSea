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
public class StoryViewFragmentTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @org.junit.Test
    public void testRead(){
        Library lib = new Library();
        lib.setIslands();
        Matcher<View> matcher = ViewMatchers.withId(R.id.sceneText);

        ViewInteraction storyVi = Espresso.onView(matcher);

        Espresso.onView(ViewMatchers.withId(R.id.moveButton)).perform(ViewActions.click());
        //check first text
        storyVi.check(ViewAssertions.matches(ViewMatchers.withText(lib.all_islands[0].getStoryScene().getText1())));

        //check second text
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        storyVi.check(ViewAssertions.matches(ViewMatchers.withText(lib.all_islands[0].getStoryScene().getText2())));

        //check question
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        storyVi.check(ViewAssertions.matches(ViewMatchers.withText(lib.all_islands[0].getStoryScene().getQuestion())));
        //check buttons
        Matcher<View> matcher2 = ViewMatchers.withId(R.id.storyOptionA);
        ViewInteraction storyVi2 = Espresso.onView(matcher2);
        Matcher<View> matcher3 = ViewMatchers.withId(R.id.storyOptionB);
        ViewInteraction storyVi3 = Espresso.onView(matcher3);
        storyVi2.check(ViewAssertions.matches(ViewMatchers.withText(lib.all_islands[0].getStoryScene().options[0].toUpperCase())));
        storyVi3.check(ViewAssertions.matches(ViewMatchers.withText(lib.all_islands[0].getStoryScene().options[1].toUpperCase())));

        //check response and ending
        Espresso.onView(ViewMatchers.withId(R.id.storyOptionA)).perform(ViewActions.click());
        storyVi.check(ViewAssertions.matches(ViewMatchers.withText(lib.all_islands[0].getStoryScene().endings[0])));
        Espresso.onView(ViewMatchers.withId(R.id.exitButton)).perform(ViewActions.click());
    }

}