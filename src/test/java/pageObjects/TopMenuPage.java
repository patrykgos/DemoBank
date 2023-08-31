package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"log_out\"]")
    private WebElement logOutButton;

    @Step("Getting info: is element displayed")
    public boolean isLogOutButtonDisplayed(){
        WaitForElement.waitUntilElementsVisible(logOutButton);
        boolean isDisplayed = logOutButton.isDisplayed();
        log().info("Returning status of logOutButton (isDisplayed): {}", isDisplayed);
        return isDisplayed;
    }

}
