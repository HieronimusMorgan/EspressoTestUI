package com.morg.espressotestui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void test_activityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_visibility_title_nextButton() {
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()));

        onView(withId(R.id.button_next_activity))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void test_navSecondaryActivity() {
        onView(withId(R.id.button_next_activity)).perform(click());

        onView(withId(R.id.secondary)).check(matches(isDisplayed()));
    }

    @Test
    public void test_backPress_to_mainActivity() {
        onView(withId(R.id.button_next_activity)).perform(click());

        onView(withId(R.id.secondary)).check(matches(isDisplayed()));

        onView(withId(R.id.button_back)).perform(click());

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_backPress_to_mainActivity_pressBack() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.button_next_activity)).perform(click());

        onView(withId(R.id.secondary)).check(matches(isDisplayed()));

        pressBack();

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

}