package id.ac.ui.cs.mobileprogramming.azharaiz.labs;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    private String NAME = "Azhar Rais";
    private String EMAIL = "azhar@gmail.com";
    private String INCORRECT_NAME = "";
    private String INCORRECT_EMAIL = "azhar.gmail.com";

    private String NAME_CORRECT_RESPONSE = "Hello Azhar Rais";
    private String NAME_INCORRECT_RESPONSE = "Name not found";
    private String EMAIL_CORRECT_RESPONSE = "Email Valid";
    private String EMAIL_INCORRECT_RESPONSE = "Email Not Valid";

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void inputCorrectData() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextName)).perform(ViewActions.typeText(NAME), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextEmail)).perform(ViewActions.typeText(EMAIL), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonSubmit)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.textGreet)).check(ViewAssertions.matches(ViewMatchers.withText(NAME_CORRECT_RESPONSE)));
        Espresso.onView(ViewMatchers.withId(R.id.textEmail)).check(ViewAssertions.matches(ViewMatchers.withText(EMAIL_CORRECT_RESPONSE)));
    }

    @Test
    public void inputIncorrectName() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextName)).perform(ViewActions.typeText(INCORRECT_NAME), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextEmail)).perform(ViewActions.typeText(EMAIL), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonSubmit)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.textGreet)).check(ViewAssertions.matches(ViewMatchers.withText(NAME_INCORRECT_RESPONSE)));
        Espresso.onView(ViewMatchers.withId(R.id.textEmail)).check(ViewAssertions.matches(ViewMatchers.withText(EMAIL_CORRECT_RESPONSE)));
    }

    @Test
    public void inputIncorrectEmail() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextName)).perform(ViewActions.typeText(NAME), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextEmail)).perform(ViewActions.typeText(INCORRECT_EMAIL), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonSubmit)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.textGreet)).check(ViewAssertions.matches(ViewMatchers.withText(NAME_CORRECT_RESPONSE)));
        Espresso.onView(ViewMatchers.withId(R.id.textEmail)).check(ViewAssertions.matches(ViewMatchers.withText(EMAIL_INCORRECT_RESPONSE)));
    }

    @Test
    public void inputIncorrectNameAndEmail() {
        Espresso.onView(ViewMatchers.withId(R.id.editTextName)).perform(ViewActions.typeText(INCORRECT_NAME), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.editTextEmail)).perform(ViewActions.typeText(INCORRECT_EMAIL), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.buttonSubmit)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.textGreet)).check(ViewAssertions.matches(ViewMatchers.withText(NAME_INCORRECT_RESPONSE)));
        Espresso.onView(ViewMatchers.withId(R.id.textEmail)).check(ViewAssertions.matches(ViewMatchers.withText(EMAIL_INCORRECT_RESPONSE)));
    }

}