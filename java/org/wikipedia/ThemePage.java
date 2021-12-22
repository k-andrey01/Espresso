package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

public class ThemePage {
    public void chooseSepia(){
        onView(allOf(withId(R.id.button_theme_sepia), isDisplayed())).perform(click());
    }
    public void goBack(){
        onView(allOf(withId(android.R.id.content), isDisplayed())).perform(pressBack());
    }
}
