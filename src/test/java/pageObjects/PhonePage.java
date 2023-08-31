package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class PhonePage extends BasePage {

    @FindBy(id = "uniform-widget_1_topup_agreement")
    private WebElement agreementCheckBox;

    @FindBy(id = "error_widget_1_topup_agreement")
    private WebElement agreementCheckBoxWarningMessage;

    @FindBy(id = "execute_btn")
    private WebElement executePhoneTopUpButton;

    @Step("Checking if agreement check box is selected")
    public Boolean isAgreementCheckBoxSelected(){
        boolean isSelected = agreementCheckBox.isSelected();
        log().info("Checked if agreement check box is selected");
        return isSelected;
    }

    @Step("Click into agreement check box")
    public PhonePage clickIntoAgreementCheckBox(){
        WaitForElement.waitUntilElementClickable(agreementCheckBox);
        agreementCheckBox.click();
        log().info("Clicked into agreement check box");
        return this;
    }

    @Step("Click into execute phone top-up button")
    public PhonePage clickIntoExecutePhoneTopUpButton(){
        WaitForElement.waitUntilElementClickable(executePhoneTopUpButton);
        executePhoneTopUpButton.click();
        log().info("Clicked into execute phone top-up button");
        return this;
    }

    @Step("Getting warning message from agreement check box")
    public String getWarningMessageFromAgreementCheckBox(){
        WaitForElement.waitUntilElementsVisible(agreementCheckBoxWarningMessage);
        String warningMessage = agreementCheckBoxWarningMessage.getText();
        log().info("Getting warning message from agreement check box");
        return warningMessage;
    }

    @Step("Checking if warning message from agreement check box id displayed")
    public Boolean isAgreementCheckBoxWarningMessageDisplayed(){
        WaitForElement.waitUntilElementsVisible(agreementCheckBoxWarningMessage);
        boolean isDisplayed = agreementCheckBoxWarningMessage.isDisplayed();
        log().info("Checked if warning message from agreement check box id displayed");
        return isDisplayed;
    }

}
