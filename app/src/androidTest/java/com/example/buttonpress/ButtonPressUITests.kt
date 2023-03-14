package com.example.buttonpress

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.buttonpress.data.ButtonPress
import com.example.buttonpress.data.getDateTime
import org.junit.BeforeClass
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ButtonPressUITests {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    private val button1 = R.id.button1
    private val buttonLogs = R.id.buttonLogs
    private val recyclerView = R.id.recycler_view

    @Test
    fun test_button_1_press() {
        // Test Button 1 click
        val bp1 = ButtonPress(buttonName = "Button 1 pressed", buttonPressedAt = System.currentTimeMillis())
        onView(withId(button1)).perform(click())

        // Open ButtonPress Logs
        onView(withId(buttonLogs)).perform(click())
        // Check if date/time added on ButtonPress Logs
        onView(withText(bp1.getDateTime())).check(matches(isDisplayed()))
    }

    companion object {
        @BeforeClass
        fun beforeClass() {
            InstrumentationRegistry.getInstrumentation().targetContext.deleteDatabase("button_press_database")
        }
    }
}