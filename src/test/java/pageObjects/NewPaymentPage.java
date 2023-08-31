package pageObjects;

import configuration.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;

import java.time.LocalDate;

public class NewPaymentPage extends BasePage {

    private String string;

    @FindBy(xpath = "//*[@id=\"form_ico_calendar\"]/i")
    private WebElement openCalendarButton;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]//select[contains(@class,\"ui-datepicker-month\")]")
    private WebElement monthPicker;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]//select[contains(@class,\"ui-datepicker-year\")]")
    private WebElement yearPicker;

    @FindBy(id = "form_date")
    private WebElement dateField;

    @Step("Opening calendar window")
    public NewPaymentPage openCalendar(){
        WaitForElement.waitUntilElementClickable(openCalendarButton);
        openCalendarButton.click();
        log().info("Clicked into open calendar button");
        return this;
    }

    @Step("Typing data to date field by calendar window")
    public NewPaymentPage setTheDateInCalendarWindow(LocalDate localDate) {
        if (localDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("wrong data");
        }

        String year = String.valueOf(localDate.getYear());
        String month = String.valueOf(localDate.getMonthValue() - 1);
        String day = String.valueOf(localDate.getDayOfMonth());

        Select dropDownYear = new Select(yearPicker);
        dropDownYear.selectByValue(year);

        Select dropDownMonth = new Select(monthPicker);
        dropDownMonth.selectByValue(month);

        WebElement dayPicker = DriverManager.getWebDriver().findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]//a[text()=" + day + "]"));
        dayPicker.click();

        log().info("Typed data to date field by calendar window");

        return this;
    }

    @Step("Getting date from date field")
    public String getDateFromDateField(){
        String text = dateField.getAttribute("value");
        log().info("Returned date from date field");
        return text;
    }
}
