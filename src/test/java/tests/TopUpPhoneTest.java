package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.PhonePage;

import static org.testng.Assert.*;

public class TopUpPhoneTest extends TestBase {

    @Test
    public void checkingIfAgreementCheckboxAndAgreementWarningMessageWorksCorrectly() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginToBank()
                .clickOnPhoneLink()
                .clickIntoExecutePhoneTopUpButton();

        PhonePage phonePage = new PhonePage();

        Boolean isSelected = phonePage.isAgreementCheckBoxSelected();
        assertFalse(isSelected);

        Boolean isDisplayed = phonePage.isAgreementCheckBoxWarningMessageDisplayed();
        assertTrue(isDisplayed);

        String actualWarningMessage = phonePage.getWarningMessageFromAgreementCheckBox();
        String expectedWarningMessage = "pole wymagane";
        assertEquals(actualWarningMessage, expectedWarningMessage);
    }
}
