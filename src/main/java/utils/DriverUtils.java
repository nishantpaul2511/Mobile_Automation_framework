package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DriverUtils {

    public static AppiumDriverLocalService service;
    public static ExtentTest logger;
    public static ExtentReports report;
    public static AppiumDriver<MobileElement> driver;


    /**
     * Returns driver for Android devices in order to execute Appium tests on
     * android devices.
     *
     * @param apkPath        Path of the APK file in the system
     * @param PackageName    Name of Package
     * @param AndroidVersion Device Software Version
     * @return AndroidDriver
     * @author NISHANT PAUL, Feb 24, 2017
     */
    public static AppiumDriver<MobileElement> setup() throws Exception {
        File app = new File("/Users/nishantpaul/Documents/Automation_code/Transcoreapksprint3.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", app.getAbsolutePath());
        cap.setCapability("appPackage", "com.transcore.ezpass"); // com.bassforecast.android
        cap.setCapability("appActivity", "com.transcore.ezpass.ui.splash.SplashActivity");
        cap.setCapability("platformVersion", "8.1.0");
        cap.setCapability("deviceName", "Nishant");
        String timestamp = new SimpleDateFormat("MMdd_HHmm").format(new Date());
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/" + Constants.ReportFilename + timestamp + ".html");
        report.loadConfig(new File("/Users/nishantpaul/Documents/Automation_code/transcore-appium/extent-config.xml"));

        AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(cap);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }


    /**
     * Returns driver for iOS devices in order to execute Appium tests on iOS
     * devices.
     *
     * @param appPath    Path of the IPA or APP file in the system
     * @param DeviceName Name of Package
     * @param UDID       Path of Main Activity
     * @param iOSVersion Device Software Version
     * @return IOSDriver
     * @author Ashraf Iftekhar, Feb 24, 2017
     */
    public static IOSDriver<MobileElement> getiOSDriver(String appPath, String DeviceName, String UDID,
                                                        String iOSVersion) {
        IOSDriver<MobileElement> iDriver = null;
        File app = new File(appPath);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", app.getAbsolutePath());
        cap.setCapability("deviceName", DeviceName);
        cap.setCapability("udid", UDID);
        cap.setCapability("platformVersion", iOSVersion);
        cap.setCapability("deviceName", DeviceName);
        cap.setCapability("platformName", "iOS");
        cap.setCapability("autoAcceptAlerts", true);
        // cap.setCapability("appActivity", LaunchActivity);


        AppiumServiceBuilder builder;
        builder = new AppiumServiceBuilder().withCapabilities(cap);

        // service = AppiumDriverLocalService.buildService(builder);

        // service.start();

        try {
            iDriver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        iDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        return iDriver;
    }

    public static void stopAppiumService() {
        service.stop();
    }
}
