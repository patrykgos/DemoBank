package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import static org.testng.Assert.*;

public class QuickTransferTests extends TestBase{

    @Test
    public void checkingIfUiDialogAfterExecuteTransferIsDisplayedAfterPositiveQuickTransfer(){
        LoginPage loginPage = new LoginPage();
        boolean actualValue = loginPage
                .loginToBank()
                .clickOnQuickPaymentLink()
                .selectTransferReceiverFromDropdown("1")
                .typeIntoAmountField(100)
                .typeInfoTitleField("title")
                .clickIntoExecuteTransferButton()
                .isUiDialogAfterExecuteTransferDisplayed();

        assertTrue(actualValue);
    }

    @Test
    public void checkingIfAfterChooseTransferReceiverFromDropDownIsEqualToExpectedReceiver(){
        LoginPage loginPage = new LoginPage();
        String actualValue = loginPage
                .loginToBank()
                .clickOnQuickPaymentLink()
                .getSelectedOptionFromTransferReceiverDropDown("1");

        String expectedValue = "Jan Demobankowy";
        assertEquals(actualValue, expectedValue);
    }
}
