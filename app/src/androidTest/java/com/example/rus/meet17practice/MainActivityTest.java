package com.example.rus.meet17practice;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkIfPresent() {
        onView(withText("Surname")).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void personCreatinoinSuccess() {
        onView(withId(R.id.surname_edittext)).perform(typeText("Tekai"),closeSoftKeyboard());
        onView(withId(R.id.name_edittext)).perform(typeText("s"),closeSoftKeyboard());
        onView(withId(R.id.second_name_edittext)).perform(typeText("sela"),closeSoftKeyboard());
        onView(withId(R.id.send_button)).perform(click());
        onView(withId(R.id.surname_textview_second)).check(ViewAssertions.matches(withText("Tekai")));
        onView(withId(R.id.second_name_textview_second)).check(ViewAssertions.matches(withText("sela")));
        onView(withId(R.id.name_textview_second)).check(ViewAssertions.matches(withText("s")));
    }

    @Test
    public void thirdActivitySuccess() {
        onView(withId(R.id.surname_edittext)).perform(typeText("Tekai"),closeSoftKeyboard());
        onView(withId(R.id.name_edittext)).perform(typeText("s"),closeSoftKeyboard());
        onView(withId(R.id.second_name_edittext)).perform(typeText("sela"),closeSoftKeyboard());
        onView(withId(R.id.send_button)).perform(click());
        onView(withId(R.id.surname_textview_second)).perform(click());
        onView(withId(R.id.third_activity_textview)).check(ViewAssertions.matches(withText("Tekai")));
    }

    @Test
    public void addingPersonsToListTest(){
        onView(withId(R.id.surname_edittext)).perform(typeText("Tekai"),closeSoftKeyboard());
        onView(withId(R.id.name_edittext)).perform(typeText("s"),closeSoftKeyboard());
        onView(withId(R.id.second_name_edittext)).perform(typeText("sela"),closeSoftKeyboard());
        onView(withId(R.id.add_to_list_button)).perform(click());
        onView(withId(R.id.surname_edittext)).perform(typeText("TEst2"),closeSoftKeyboard());
        onView(withId(R.id.name_edittext)).perform(typeText("SecondName"),closeSoftKeyboard());
        onView(withId(R.id.second_name_edittext)).perform(typeText("SecondSecondNAme"),closeSoftKeyboard());
        onView(withId(R.id.add_to_list_button)).perform(click());
        onView(withId(R.id.surname_edittext)).perform(typeText("3"),closeSoftKeyboard());
        onView(withId(R.id.name_edittext)).perform(typeText("3"),closeSoftKeyboard());
        onView(withId(R.id.second_name_edittext)).perform(typeText("3"),closeSoftKeyboard());
        onView(withId(R.id.add_to_list_button)).perform(click());
        onView(withId(R.id.check_list_button)).perform(click());
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.<MyAdapter.MyViewHolder>scrollToPosition(1))
                .perform(RecyclerViewActions.<MyAdapter.MyViewHolder>actionOnItemAtPosition(1, click()));
        onView(withId(R.id.surname_textview_second)).check(ViewAssertions.matches(withText("TEst2")));
        onView(withId(R.id.second_name_textview_second)).check(ViewAssertions.matches(withText("SecondSecondNAme")));
        onView(withId(R.id.name_textview_second)).check(ViewAssertions.matches(withText("SecondName")));
    }
}
