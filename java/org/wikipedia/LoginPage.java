package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class LoginPage {
    public void startLogin(){
        onView(allOf(withId(R.id.create_account_login_button), isDisplayed())).perform(click());
    }
    public void enterLogin(){
        onView(allOf(withHint("Username"),isDisplayed())).perform(typeText("AnVKazancev"));
    }
    public void enterPassword(){
        onView(allOf(withHint("Password"), isDisplayed())).perform(typeText("fifa2014"));
    }
    public void clickLogin(){
        onView(allOf(withId(R.id.login_button), isDisplayed())).perform(click());
    }
}
