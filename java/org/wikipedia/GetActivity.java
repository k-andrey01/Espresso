package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

public class GetActivity
{

    public static Activity getActivityInstance() {
        final Activity[] activity = new Activity[1];

        onView(isRoot()).check((view, noViewFoundException) -> {

            View checkedView = view;

            while (checkedView instanceof ViewGroup && ((ViewGroup) checkedView).getChildCount() > 0) {

                checkedView = ((ViewGroup) checkedView).getChildAt(0);

                if (checkedView.getContext() instanceof Activity) {
                    activity[0] = (Activity) checkedView.getContext();
                    return;
                }
            }
        });
        return activity[0];
    }
}