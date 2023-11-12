package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import com.google.android.material.textfield.TextInputEditText
import org.hamcrest.Matchers.allOf

class CreatePage : AbstractPage(R.id.createFrameLayout) {

    fun inputText(text: String) {
        onView(
            allOf(
                isAssignableFrom(TextInputEditText::class.java),
                withParent(withId(root)),
                withId(R.id.inputEditText)
            )
        ).perform(typeText(text), closeSoftKeyboard())
    }

    fun clickCreateButton() {
        onView(
            allOf(
                isAssignableFrom(Button::class.java),
                withParent(withId(root)),
                withId(R.id.createButton)
            )
        ).perform(click())
    }

    fun checkButtonEnabled() {
        onView(withId(R.id.createButton)).check(matches(isEnabled()))
    }

    fun checkButtonNotEnabled() {
        onView(withId(R.id.createButton)).check(matches(isNotEnabled()))
    }
}