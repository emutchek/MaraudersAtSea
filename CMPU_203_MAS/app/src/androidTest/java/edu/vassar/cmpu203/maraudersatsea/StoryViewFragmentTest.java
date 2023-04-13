package edu.vassar.cmpu203.maraudersatsea;
import edu.vassar.cmpu203.maraudersatsea.controller.MainActivity;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
//import static org.junit.jupiter.api.Assertions.*;

@RunWith(AndroidJUnit4.class)
public class StoryViewFragmentTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testRead(){
        Matcher<View> matcher = ViewMatchers.withId(R.id.storyOptionA);
        ViewInteraction storyVi = Espresso.onView(matcher);
        Espresso.onView(matcher).perform(ViewActions.click());
    }

}