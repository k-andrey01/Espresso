package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class MainPage {
    public void clickMore(){
        onView(allOf(withId(R.id.nav_more_container), isDisplayed())).perform(click());
    }
    public void clickSearch(){
        onView(allOf(withText("Search"),isDisplayed())).perform(click());
    }
}
