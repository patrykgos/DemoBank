package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class ContentPageLeftBar extends BasePage {

    @FindBy(xpath = "//nav[@class=\"nav-main\"]//a[contains(@href, \"quick_payment.html\")]")
    private WebElement quickPaymentLink;

    @FindBy(xpath = "//nav[@class=\"nav-main\"]//a[contains(@href, \"phone.html\")]")
    private WebElement phoneLink;

    @FindBy(xpath = "//nav[@class=\"nav-main\"]//a[contains(@href, \"przelew_nowy_zew.html\")]")
    private WebElement newPaymentLink;

    @FindBy(xpath = "//nav[@class=\"nav-main\"]//a[contains(@href, \"reports.html\")]")
    private WebElement reportsLink;

    @FindBy(xpath = "//nav[@class=\"nav-main\"]//a[contains(@href, \"reports-iframe.html\")]")
    private WebElement reportsIframeLink;

    @Step("Click on quickPaymentLink")
    public QuickPaymentPage clickOnQuickPaymentLink() {
        WaitForElement.waitUntilElementClickable(quickPaymentLink);
        quickPaymentLink.click();
        log().info("Clicked into quickPaymentLink");
        return new QuickPaymentPage();
    }

    @Step("Click on phoneLink")
    public PhonePage clickOnPhoneLink() {
        WaitForElement.waitUntilElementClickable(phoneLink);
        phoneLink.click();
        log().info("Clicked into phoneLink");
        return new PhonePage();
    }

    @Step("Click on newPaymentLink")
    public NewPaymentPage clickOnNewPayment() {
        WaitForElement.waitUntilElementClickable(newPaymentLink);
        newPaymentLink.click();
        log().info("Clicked into newPaymentLink");
        return new NewPaymentPage();
    }

    @Step("Click on reportsLink")
    public ReportsPage clickOnReportsLink() {
        WaitForElement.waitUntilElementClickable(reportsLink);
        reportsLink.click();
        log().info("Clicked into reportsLink");
        return new ReportsPage();
    }

    @Step("Click on reportsIframeLink")
    public ReportsIframePage clickOnReportsIframeLink() {
        WaitForElement.waitUntilElementClickable(reportsIframeLink);
        reportsIframeLink.click();
        log().info("Clicked into reportsIframeLink");
        return new ReportsIframePage();
    }
}
