package com.kotlin.expresso

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ApplicationTest {

    @Rule @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testToAdd() {
        onView(withId(R.id.button_one)).perform(click())
        onView(withId(R.id.button_two)).perform(click())
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_add)).perform(click())
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_two)).perform(click())
        onView(withId(R.id.button_one)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("${123 + 321}")))
    }

    @Test
    fun testToSub() {
        onView(withId(R.id.button_nine)).perform(click())
        onView(withId(R.id.button_nine)).perform(click())
        onView(withId(R.id.button_nine)).perform(click())
        onView(withId(R.id.button_sub)).perform(click())
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("${999 - 333}")))
    }

    @Test
    fun testToMulti() {
        onView(withId(R.id.button_one)).perform(click())
        onView(withId(R.id.button_zero)).perform(click())
        onView(withId(R.id.button_zero)).perform(click())
        onView(withId(R.id.button_multi)).perform(click())
        onView(withId(R.id.button_two)).perform(click())
        onView(withId(R.id.button_zero)).perform(click())
        onView(withId(R.id.button_zero)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("20,000")))
    }

    @Test
    fun testToDiv() {
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_three)).perform(click())
        onView(withId(R.id.button_divide)).perform(click())
        onView(withId(R.id.button_one)).perform(click())
        onView(withId(R.id.button_zero)).perform(click())
        onView(withId(R.id.button_zero)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.result)).check(matches(withText("${333 / 100.0}")))
    }
}