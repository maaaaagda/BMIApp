package com.polak.magda.lab_1;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.text.DecimalFormat;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by DELL on 25.03.2017.
 */

public class Espresstest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    // Looks for an EditText with id = "R.id.etInput"
    // Types the text "Hello" into the EditText
    // Verifies the EditText has text "Hello"
    float testHeight = 1.65f;
    float testWeight = 65f;
    float expectedResult = testWeight/(testHeight*testHeight);
    DecimalFormat df = new DecimalFormat("#.##");
    String dBMI = df.format(expectedResult);
    @Test
    public void validateEditHeight() {
        onView(withId(R.id.editHeight)).perform(typeText(Float.toString(testHeight)))
                .check(matches(withText(Float.toString(testHeight))));
    }
    @Test
    public void validateEditWeight() {
        onView(withId(R.id.editWeight)).perform(typeText(Float.toString(testWeight)))
                .check(matches(withText(Float.toString(testWeight))));
    }
    @Test
    public void validateBMI() {
        onView(withId(R.id.editWeight)).perform(typeText(Float.toString(testWeight)));
        onView(withId(R.id.editHeight)).perform(typeText(Float.toString(testHeight)));
        closeSoftKeyboard();
        onView(withId(R.id.buttonCountBMI)).perform(click());
        onView(withId(R.id.textViewResult)).check(matches(withText(dBMI)));

    }
}
