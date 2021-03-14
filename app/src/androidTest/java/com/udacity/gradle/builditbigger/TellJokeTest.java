package com.udacity.gradle.builditbigger;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TellJokeTest {

  @Rule
  public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(
      MainActivity.class);

  @Test
  public void listGoesOverTheFold() {
    onView(withText(getResourceString(R.string.button_text))).check(matches(isDisplayed()));
    onView(withText(getResourceString(R.string.button_text))).perform(click());

    onView(withId(R.id.joke_text)).check(matches(not(withText(""))));
  }

  private String getResourceString(int id) {
    Context targetContext = ApplicationProvider.getApplicationContext();
    return targetContext.getResources().getString(id);
  }
}
