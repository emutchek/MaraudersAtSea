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
public class GridViewFragmentTest {
    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testMove (){
        // match a view by id
        Matcher<View> matcher = ViewMatchers.withId(R.id.s1L);

        ViewInteraction gridVi = Espresso.onView(matcher);

        gridVi.check(ViewAssertions
                .matches(ViewMatchers
                        .withTagValue(Matchers.equalTo(R.drawable.island))));

        Espresso.onView(ViewMatchers.withId(R.id.moveButton)).perform(ViewActions.click());
        //wait for two seconds
        SystemClock.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        SystemClock.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.nextButton)).perform(ViewActions.click());
        SystemClock.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.storyOptionA)).perform(ViewActions.click());
        SystemClock.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitButton)).perform(ViewActions.click());
        SystemClock.sleep(2000);
        Matcher<View> matcher2 = ViewMatchers.withId(R.id.s0L);
        gridVi = Espresso.onView(matcher2);

        gridVi.check(ViewAssertions
                .matches(ViewMatchers
                        .withId(R.drawable.island)));

        //note for later:
        //.withClassName(Matchers.containsString("ImageView"));
    }
}