package base;

import constants.Constants;
import constants.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.BeforeClass;
import utils.DriverUtils;

public class BaseTest {

    public AppiumDriver<MobileElement> driver;
    // protected ExtentTest logger = Logger.getLogger("myLogger");

    private void createAndroidDriver() throws Exception {
        driver = DriverUtils.setup();
    }

    private void createIosDriver() {
        // TODO Create IOS Driver
    }

    /**
     * Creates the basic setup for the tests
     */
    @BeforeClass
    public void before() throws Exception {
        // TODO Initialize the driver and start Appium Service using the DriverUtils
        if (driver == null) {
            if (Constants.platform == Platform.ANDROID) {
                createAndroidDriver();
            } else {
                createIosDriver();
            }
        } else {
            if (Constants.platform == Platform.ANDROID && driver instanceof IOSDriver) {
                driver = null;
                createAndroidDriver();
            } else if (Constants.platform == Platform.IOS && driver instanceof AndroidDriver) {
                driver = null;
                createIosDriver();
            }
        }
    }


//    /**
//     * Releases resources after the test has been executed
//     */
//    @AfterClass
//    public void tearDown() {
//        // TODO Quit the driver and stop Appium Service using the DriverUtils
//
//
//    }
}
