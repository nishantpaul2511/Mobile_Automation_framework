package feature.Demo;

import com.relevantcodes.extentreports.LogStatus;
import constants.Constants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.GenericMethods;

import static utils.DriverUtils.logger;
import static utils.DriverUtils.report;

/**
 * @author NISHANT PAUL || 9th JAN 2019
 * @category DemoTest
 */

public class DemoTest {

    // TODO Create objects for the page classes here
    //  private DemoPage demoPage = new DemoPage(driver);
    AppiumDriver<WebElement> driver;

    @BeforeSuite
    public void setup() throws Exception {
        GenericMethods.SetupAppiumDriver();


    }
    // This method is to verify the splash screen of the application is appearing or not.

    @Test(priority = 0, enabled = true) //To check whether the splash screen displayed or not.
    public void splashScreen() throws Exception {

        try {
            logger = report.startTest("Splash screen");
            logger.log(LogStatus.INFO, "Verifying the Splash Screen");
            String screenshot1Pass = GenericMethods.CaptureScreenshotAsBase64("Splashscreen");
            logger.log(LogStatus.PASS, "Splash Screen appeared" + logger.addBase64ScreenShot(screenshot1Pass));
        } catch (Exception e) {
            String Screenshot1Fail = GenericMethods.CaptureScreenshotAsBase64("Splashscreen");
            logger.log(LogStatus.FAIL, "Splash Screen appeared" + logger.addBase64ScreenShot(Screenshot1Fail));
        }

    }

    // This method is to check the login functionality of the application.

    @Test(priority = 1, enabled = true)

    public void login() throws Exception {

        try {
            logger = report.startTest("Login Screen");
            logger.log(LogStatus.INFO, "Enter the username : firstUser");
            GenericMethods.sendData("username", Constants.name);

            logger.log(LogStatus.INFO, "Enter the password : password");
            GenericMethods.sendData("password", Constants.passwordfield);
            String screenshot1Pass = GenericMethods.CaptureScreenshotAsBase64("Login screen");
            logger.log(LogStatus.PASS, "User is able to enter the username and password" + logger.addBase64ScreenShot(screenshot1Pass));

        } catch (Exception e) {
            String screenshot1Fail = GenericMethods.CaptureScreenshotAsBase64("Login screen");
            logger.log(LogStatus.FAIL, "User is not able to enter the username and password" + logger.addBase64ScreenShot(screenshot1Fail));
        }

        try {
            GenericMethods.HideKeyboard();
            GenericMethods.ClickOnButton("login_ button_click");

            String screenshot2Pass = GenericMethods.CaptureScreenshotAsBase64("Click on Login");
            logger.log(LogStatus.PASS, "Clicked on login button" + logger.addBase64ScreenShot(screenshot2Pass));
        } catch (Exception e) {
            String screenshot2Fail = GenericMethods.CaptureScreenshotAsBase64("Click on Login");
            logger.log(LogStatus.FAIL, "User not able to click on login button" + logger.addBase64ScreenShot(screenshot2Fail));

        }
    }

    @Test(priority = 2, enabled = true)

    public void homescreen() throws Exception {
        logger = report.startTest("Home Screen");
        logger.log(LogStatus.INFO, "Verify the Home Screen");

        logger.log(LogStatus.INFO, "Verify the text visibility : BALANCE DUE");
        try {
            GenericMethods.ElementDisplayed("balance_due");
            logger.log(LogStatus.PASS, "Verified the text : BALANCE DUE");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : BALANCE DUE");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Account Replenishment with Credit Card");
        try {
            GenericMethods.ElementDisplayed("auto_replenishment_with_credit_card");
            logger.log(LogStatus.PASS, "Verified the text : Auto Replenishment with Credit Card");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Auto Replenishment with Credit Card");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Last Replenishment");
        try {
            GenericMethods.ElementDisplayed("last_replenishment");
            logger.log(LogStatus.PASS, "Verified the text : Last Replenishment");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Last Replenishment");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Account Status");
        try {
            GenericMethods.ElementDisplayed("account_status");
            logger.log(LogStatus.PASS, "Verified the text : Account Status");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Account Status");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Account Alert");
        try {
            GenericMethods.ElementDisplayed("account_alert");
            logger.log(LogStatus.PASS, "Verified the text : Account Alert");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Account Alert");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : What are you looking for ?");
        try {
            GenericMethods.ElementDisplayed("what_are_looking_for");
            logger.log(LogStatus.PASS, "Verified the text : What are you looking for ?");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : What are you looking for ?");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Summary");
        try {
            GenericMethods.ElementDisplayed("summary_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Summary");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Summary");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Profile");
        try {
            GenericMethods.ElementDisplayed("profile_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Profile");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Profile");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Transaction");
        try {
            GenericMethods.ElementDisplayed("transaction_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Transaction");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Transaction");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Billing");
        try {
            GenericMethods.ElementDisplayed("billing_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Billing");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Billing");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Vehicle");
        try {
            GenericMethods.ElementDisplayed("vehicle_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Vehicle");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Vehicle");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Transponder");
        try {
            GenericMethods.ElementDisplayed("transponder_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Transponder");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Transponder");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Alert");
        try {
            GenericMethods.ElementDisplayed("alert_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Alert");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Alert");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Statements");
        try {
            GenericMethods.ElementDisplayed("statements_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Statements");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Statements");
        }

        logger.log(LogStatus.INFO, "Verify the text visibility : Contact");
        try {
            GenericMethods.ElementDisplayed("contact_homescreen");
            logger.log(LogStatus.PASS, "Verified the text : Contact");
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Text not verified : Contact");
        }


    }


    // This method is to check the validation of the each and every priority,
    // whether the test module is getting Failed or Pass and we are flushing the Test data once the test is getting completed.

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshot_path = GenericMethods.CaptureScreenshotAsBase64(result.getName());
            String image = logger.addScreenCapture(screenshot_path);
            logger.log(LogStatus.FAIL, result.getThrowable());
            logger.log(LogStatus.FAIL, "Demo Application Automation Test Failed Snapshot below: ");
            logger.log(LogStatus.FAIL, result.getName(), image);

        }

        if (result.getStatus() == ITestResult.SUCCESS) {
            String screenshot_path = GenericMethods.CaptureScreenshotAsBase64(result.getName());
            String image = logger.addBase64ScreenShot(screenshot_path);
            logger.log(LogStatus.PASS, "Demo Application Automation Test Passed Snapshot below: ");
            logger.log(LogStatus.PASS, result.getName(), image);

        }
        report.endTest(logger);
        report.flush();

    }


}
