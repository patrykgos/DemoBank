package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static org.testng.Assert.*;

public class LoadingFilesTests extends TestBase {

    @Test
    public void isUploadedFileNameEqualToFileNameOnWebsite() {
        LoginPage loginPage = new LoginPage();

        String actualFileName = loginPage
                .loginToBank()
                .clickOnReportsLink()
                .uploadFile("C:\\raport.txt")
                .getFileName();

        String expectedFileName = "raport.txt";
        assertEquals(actualFileName, expectedFileName);
    }

    @Test
    public void isUploadedFileNameEqualToFileNameOnWebsiteIFrame() {
        LoginPage loginPage = new LoginPage();

        String actualFileName = loginPage
                .loginToBank()
                .clickOnReportsIframeLink()
                .switchToIframe()
                .uploadFile("C:\\raport.txt")
                .getFileName();

        String expectedFileName = "raport.txt";
        assertEquals(actualFileName, expectedFileName);
    }
}
