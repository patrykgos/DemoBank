package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LoginPage extends BasePage {

    @FindBy(id = "login_id")
    private WebElement loginField;

    @FindBy(id = "login_password")
    private WebElement passwordField;

    @FindBy(id = "login-btn")
    private WebElement loginButton;

    @FindBy(id = "error_login_id")
    private WebElement wrongLoginMessage;

    @FindBy(id = "error_login_password")
    private WebElement wrongPasswordMessage;

    @Step("Type into login field {login}")
    public LoginPage typeIntoLoginField(String login) {
        loginField.clear();
        loginField.sendKeys(login);
        log().info("Typed into loginField: {}", login);
        return this;
    }

    @Step("Type info password field{password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password + Keys.TAB);
        log().info("Typed into password field: {}", password);
        return this;
    }

    @Step("Click into Login button")
    public ContentPageLeftBar clickLoginButton() {
        WaitForElement.waitUntilElementClickable(loginButton);
        loginButton.click();
        log().info("Clicked into login link");
        return new ContentPageLeftBar();
    }

    @Step("Getting warning message from login field")
    public String getWrongLoginWarningMessage() {
        WaitForElement.waitUntilElementsVisible(wrongLoginMessage);
        String warningText = wrongLoginMessage.getText();
        log().info("Returned warning message was: {}", warningText);
        return warningText;
    }

    @Step("Getting warning message from password field")
    public String getWrongPasswordWarningMessage() {
        WaitForElement.waitUntilElementsVisible(wrongPasswordMessage);
        String warningText = wrongPasswordMessage.getText();
        log().info("Returned warning message was: {}", warningText);
        return warningText;
    }

    @Step("Logging to bank website")
    public ContentPageLeftBar loginToBank() {
        loginField.clear();
        loginField.sendKeys("12345678");
        passwordField.clear();
        passwordField.sendKeys("12345678");
        loginButton.click();
        return new ContentPageLeftBar();
    }
}
