package com.morg.espressotestui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class SecondaryActivityTest {
    @Rule
    public ActivityScenarioRule<SecondaryActivity> activityScenarioRule =
            new ActivityScenarioRule<SecondaryActivity>(SecondaryActivity.class);

    @Test
    public void test_activityInView() {
        onView(withId(R.id.secondary)).check(matches(isDisplayed()));
    }



}