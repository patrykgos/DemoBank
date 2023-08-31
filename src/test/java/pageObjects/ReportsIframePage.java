package pageObjects;

import configuration.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsIframePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"uniform-my_file_1\"]/span[1]")
    private WebElement fileNameSpot;

    @FindBy(xpath = "//*[@id=\"my_file_1\"]")
    private WebElement uploadFileButton;

    @FindBy(xpath = "//*[@id=\"main_content\"]/iframe")
    private WebElement iFrame;

    @Step("Switching to Iframe")
    public ReportsIframePage switchToIframe(){
        DriverManager.getWebDriver().switchTo().frame(iFrame);
        log().info("switched to iframe");
        return this;
    }

    @Step("Uploading file")
    public ReportsIframePage uploadFile(String path) {
        uploadFileButton.sendKeys(path);
        log().info("File uploaded");
        return this;
    }

    @Step("Getting file name from file name spot")
    public String getFileName(){
        String fileName = fileNameSpot.getText();
        log().info("Returned file name from file name spot");
        return fileName;
    }

}
