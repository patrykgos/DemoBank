package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"uniform-my_file_1\"]/span[1]")
    private WebElement fileNameSpot;

    @FindBy(xpath = "//*[@id=\"my_file_1\"]")
    private WebElement uploadFileButton;

    @Step("Uploading file")
    public ReportsPage uploadFile(String path) {
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
