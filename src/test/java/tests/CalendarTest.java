package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import static org.testng.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarTest extends TestBase {
    
    @Test
    public void whetherGivenValueToCalendarWindowEqualToDateFieldOnWebsite() {
        LocalDate expectedDate = LocalDate.of(2023, 10, 15);
        LocalDate wrongDate = LocalDate.of(2023, 10, 10);

        LoginPage loginPage = new LoginPage();
        String stringDate = loginPage.loginToBank()
                .clickOnNewPayment()
                .openCalendar()
                .setTheDateInCalendarWindow(expectedDate)
                .getDateFromDateField();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate actualDate = LocalDate.parse(stringDate, formatter);
        assertEquals(actualDate, wrongDate);
    }
}
