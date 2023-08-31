package pageObjects;

import configuration.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public Actions action(){
        return new Actions(DriverManager.getWebDriver());
    }

    protected  Logger log(){
        return logger;
    }
}
