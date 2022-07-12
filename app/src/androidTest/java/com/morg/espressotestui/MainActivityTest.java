package com.morg.espressotestui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
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
    public void test_changeFragment() {
        onView(withId(R.id.btn_movie_detail)).perform(click());

        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()));
//
//        onView(withId(R.id.tv_movie_detail)).check(matches(isDisplayed())).perform(clearText(), typeText("This is Movie Detail Fragment"));
        pauseTestFor(500);
        onView(withId(R.id.btn_directors)).perform(click());

        onView(withId(R.id.fragment_directors_parent)).check(matches(isDisplayed()));
        pauseTestFor(500);

        onView(withId(R.id.btn_star_actor)).perform(click());

        onView(withId(R.id.fragment_star_actor_parent)).check(matches(isDisplayed()));
        pauseTestFor(500);

    }

    private void pauseTestFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}