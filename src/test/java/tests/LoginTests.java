package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TopMenuPage;

import static org.testng.Assert.*;

public class LoginTests extends TestBase {

    @Test
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoLoginField("1234567")
                .typeIntoPasswordField("1234567");

        String actualWarningLoginMessage = loginPage.getWrongLoginWarningMessage();
        String expectedWarningLoginMessage = "identyfikator ma min. 8 znaków";
        assertEquals(actualWarningLoginMessage, expectedWarningLoginMessage);

        String actualWarningPasswordMessage = loginPage.getWrongPasswordWarningMessage();
        String expectedWarningPasswordMessage = "hasło ma min. 8 znaków";
        assertEquals(actualWarningPasswordMessage, expectedWarningPasswordMessage);
    }

    @Test
    public void positiveLoginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoLoginField("12345678")
                .typeIntoPasswordField("12345678")
                .clickLoginButton();
        TopMenuPage topMenuPage = new TopMenuPage();

        boolean isDisplayed = topMenuPage.isLogOutButtonDisplayed();
        assertTrue(isDisplayed);
    }
}