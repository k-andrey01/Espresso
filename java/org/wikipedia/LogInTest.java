package org.wikipedia;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.wikipedia.main.MainActivity;
import org.wikipedia.settings.SettingsActivity;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogInTest {
    GetActivity getActivity;
    LoginPage loginPage;
    MainPage mainPage;
    SettingsPage settingsPage;
    ThemePage themePage;
    WinPage winPage;
    MorePage morePage;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initGetActivity() {
        getActivity = new GetActivity();
        loginPage=new LoginPage();
        mainPage=new MainPage();
        settingsPage=new SettingsPage();
        themePage=new ThemePage();
        winPage=new WinPage();
        morePage=new MorePage();
    }

    @Test
    public void logInTest() throws InterruptedException {
        winPage.skipMessage();

        mainPage.clickMore();

        settingsPage.logIn();

        loginPage.startLogin();

        loginPage.enterLogin();

        loginPage.enterPassword();

        loginPage.clickLogin();

        TestUtil.delay(5);

        winPage.skipThanks();

        //onView(allOf(withId(R.id.main_toolbar_wordmark))).check(matches(isDisplayed()));

        Assert.assertTrue(getActivity.getActivityInstance().getClass().equals(MainActivity.class));
    }

    @Test
    public void toSearchTest() throws InterruptedException {
        winPage.skipMessage();

        mainPage.clickSearch();

        Assert.assertTrue(getActivity.getActivityInstance().getClass().equals(MainActivity.class));

        //onView(allOf(withId(R.id.history_title))).check(matches(isDisplayed()));
    }

    //смена темы проверяется по нахождению соответствующего текста в настройках, а не по активити, поэтому тут метод обработки
    //активити не нужен
    @Test
    public void changeThemeTest() throws InterruptedException {
        winPage.skipMessage();

        mainPage.clickMore();

        morePage.clickSettings();

        settingsPage.clickTheme();

        themePage.chooseSepia();

        themePage.goBack();

        Assert.assertTrue(getActivity.getActivityInstance().getClass().equals(SettingsActivity.class));

        onView(allOf(withText("Sepia"))).check(matches(isDisplayed()));
    }

    //здесь мы ловим тост, поэтому активити не ловим
    @Test
    public void zlogOutTest(){
        winPage.skipMessage();

        mainPage.clickMore();

        morePage.clickSettings();

        settingsPage.swipeUp();

        settingsPage.logOut();

        winPage.acceptLogout();

        onView(withText(R.string.toast_logout_complete)).check(matches(isDisplayed()));

        Assert.assertTrue(getActivity.getActivityInstance().getClass().equals(MainActivity.class));
    }
}
