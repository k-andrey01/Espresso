package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class WinPage {
    public void skipMessage(){
        onView(allOf(withId(R.id.fragment_onboarding_skip_button), isDisplayed())).perform(click());
    }
    public void skipThanks(){
        onView(allOf(withText("NO THANKS"),isDisplayed())).perform(click());
    }
    public void acceptLogout(){
        onView(allOf(withText("LOG OUT"), isDisplayed())).perform(click());
    }
}
