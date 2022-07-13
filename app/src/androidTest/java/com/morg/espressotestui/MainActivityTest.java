package com.morg.espressotestui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule = new ActivityScenarioRule<>(
            MainActivity.class);

    @Test
    public void test_showDialog() {
        onView(withId(R.id.button_take_photo)).perform(click());

        onView(withText("Dialog")).check(matches(isDisplayed()));

        onView(withId(R.id.et_text)).perform(typeText("Hieronimus Fredy Morgan"));

        onView(withId(R.id.btn_ok)).perform(click());

        onView(withId(R.id.tv_detail_parent)).check(matches(withText("Hieronimus Fredy Morgan")));

    }
}