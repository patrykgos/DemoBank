package configuration;

import configuration.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final BrowserType BROWSER_TYPE = BrowserType.CHROME;

    private static WebDriver driver;
    private static BrowserType type;

    private DriverManager() {
    }

    public static void setWebDriver(BrowserType browserType) {
        WebDriver browser = null;
        if (browserType == null) {
            browserType = BROWSER_TYPE;
            browser = BrowserFactory.getBrowser(browserType);
        } else {
            browser = BrowserFactory.getBrowser(browserType);
        }

        browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

        type = browserType;
        driver = browser;
    }

    public static synchronized WebDriver getWebDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }
        return driver;
    }

    public static void disposeDriver() {
        if (driver != null) {
            driver.close();
            if (!type.equals(BrowserType.FIREFOX)) {
                driver.quit();
            }
            driver = null;
        }
    }
}

