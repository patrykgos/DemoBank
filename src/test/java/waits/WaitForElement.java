package waits;

import configuration.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class WaitForElement {

    private static Logger logger = LogManager.getLogger(WaitForElement.class.getName());

    protected static Logger log(){
        return logger;
    }

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
    }

    public static void waitUntilElementsVisible(WebElement element) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        log().info("wait until element visible");
    }

    public static void waitUntilElementClickable(WebElement element){
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        log().info("wait until element clickable");
    }
}

