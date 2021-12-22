package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.action.ViewActions;

public class SettingsPage {
    public void logIn(){
        onView(allOf(withId(R.id.main_drawer_login_button), isDisplayed())).perform(click());
    }
    public void clickTheme(){
        onView(allOf(withText("App theme"), isDisplayed())).perform(click());
    }
    public void swipeUp(){
        onView(withId(android.R.id.content)).perform(ViewActions.swipeUp());
    }
    public void logOut(){
        onView(allOf(withId(R.id.logoutButton), isDisplayed())).perform(click());
    }
}
