package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

public class QuickPaymentPage extends BasePage {

    @FindBy(id = "widget_1_transfer_receiver")
    private WebElement transferReceiverDropDown;

    @FindBy(id = "widget_1_transfer_amount")
    private WebElement transferAmountField;

    @FindBy(id = "widget_1_transfer_title")
    private WebElement transferTitleField;

    @FindBy(id = "execute_btn")
    private WebElement executeTransferButton;

    @FindBy(xpath = "/html/body/div[3]")
    private WebElement uiDialogAfterExecuteTransfer;

    @Step("Getting selected option from transfer receiver drop down")
    public String getSelectedOptionFromTransferReceiverDropDown(String value){
        Select dropDown = new Select(transferReceiverDropDown);
        dropDown.selectByValue(value);
        String chosenOption = dropDown
                .getFirstSelectedOption()
                .getText();
        log().info("Getting chosen option from transfer receiver drop down");
        return chosenOption;
    }

    @Step("Selecting transfer receiver from drop down")
    public QuickPaymentPage selectTransferReceiverFromDropdown(String value){
        Select dropDown = new Select(transferReceiverDropDown);
        dropDown.selectByValue(value);
        log().info("selected transfer receiver from drop down");
        return this;
    }

    @Step("Type into amount field{amount}")
    public QuickPaymentPage typeIntoAmountField(double amount){
        transferAmountField.clear();
        transferAmountField.sendKeys(String.valueOf(amount));
        log().info("typing into amount field");
        return this;
    }

    @Step("Type into transfer title field")
    public QuickPaymentPage typeInfoTitleField(String title){
        transferTitleField.clear();
        transferTitleField.sendKeys(title);
        log().info("typing into title field");
        return this;
    }

    @Step("Click into execute transfer button")
    public QuickPaymentPage clickIntoExecuteTransferButton(){
        WaitForElement.waitUntilElementClickable(executeTransferButton);
        executeTransferButton.click();
        log().info("clicked into execute transfer button");
        return this;
    }

    @Step("Getting info: is element displayed")
    public boolean isUiDialogAfterExecuteTransferDisplayed(){
        boolean isDisplayed = uiDialogAfterExecuteTransfer.isDisplayed();
        log().info("Returning status of logOutButton (isDisplayed): {}", isDisplayed);
        return isDisplayed;
    }
}
