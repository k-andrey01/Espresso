package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class MorePage {
    public void clickSettings(){
        onView(allOf(withId(R.id.main_drawer_settings_container), isDisplayed())).perform(click());
    }
}
