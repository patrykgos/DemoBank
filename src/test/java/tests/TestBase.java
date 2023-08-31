package tests;

import configuration.BrowserType;
import configuration.DriverManager;
import configuration.DriverUtils;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    public static final String APPLICATION_URL = "https://demo-bank.vercel.app/";

    @Step("Preparation of WebDriver")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }

}