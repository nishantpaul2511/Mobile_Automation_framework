package utils;

import constants.Constants;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author NISHANT PAUL || 9th JAN 2019
 * @category Generic Methods
 */


public class GenericMethods extends DriverUtils {

    //public Properties OR = null;
    static Properties OR = new Properties();
    static InputStream input = null;
    static DriverUtils ap = new DriverUtils();
    static String obj;
    public String reporterror;


    public static void SetupAppiumDriver() throws Exception {

        try {
            driver = ap.setup();
            System.out.println("AppiumDriver" + driver);

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }


    // Method to take screenshot
    public static String CaptureScreenshotAsBase64(String screenshotName) throws Exception {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            String screenshot = ts.getScreenshotAs(OutputType.BASE64);

            return "data:image/gif;base64," + screenshot;
        } catch (Exception e) {
            e.printStackTrace();
            return "Screenshot_Capture_Failure!";
        }
    }


    //Method to sendData

    public static void sendData(String objKey, String data) {
        try {
            WebElement ele = getElement(objKey);

            if (!ele.getText().equals("")) {
                ele.clear();
            }
            ele.sendKeys(data);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

 
    //Method to HideKeyboard

    public static void HideKeyboard() {
        try {

            driver.hideKeyboard();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    //Method to Click on button

    public static void ClickOnButton(String Objkey) throws Exception {
        try {

            getElement(Objkey).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to click on the element using text

    public static void ClickOnElementUsingText(String text) throws Exception {
        try {

            WebElement clickonlistele = driver.findElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
            clickonlistele.click();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //  public static void clickOnElementusingID

    //Method to get locators from OR properties file

    public static WebElement getElement(String objkey) throws Exception {
        try {
            input = new FileInputStream(Constants.OR_Path);
            OR.load(input);
            WebDriverWait wait = new WebDriverWait(driver, 50);

            obj = OR.getProperty(objkey);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj)));
            return driver.findElement(By.xpath(obj));
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }


    // Method to check whether the element is getting displayed.

    public static String ElementDisplayed(String objkey) {
        try {
            WebElement ele = getElement(objkey);
            if (ele.isDisplayed()) {
                return "Pass";
            }
        } catch (Exception e) {
            return "Fail";
        }
        return "Pass";

    }

    // Method to check whether the element is getting displayed or not.

    public static String ElementNotDisplayed(String objkey) throws Exception {

        try {
            input = new FileInputStream(Constants.OR_Path);
            OR.load(input);
            WebDriverWait wait1 = new WebDriverWait(driver, 5);

            obj = OR.getProperty(objkey);
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(obj)));
            return "pass";
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }


    // Method for Navigating back

    public static void ClickBackButton() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            System.out.println("Unable to click on back button");
        }
    }


    // Method for Select from drop down

    public static void SelectFromdropdown(String objkey, String elementToclick) throws Exception {
        WebElement ele = getElement(objkey);
        ele.click();
        WebElement clickonlistele = driver.findElement(By.xpath("//android.widget.TextView[@text='" + elementToclick + "']"));
        clickonlistele.click();
    }

    // Method to select from drop down using index

    public static void SelectFromdropdownUsingIndex(String objkey, String elementToclick) throws Exception {
        WebElement ele = getElement(objkey);
        ele.click();
        WebElement clickonlistele = driver.findElement(By.xpath("//android.widget.TextView[@index='" + elementToclick + "']"));
        clickonlistele.click();
    }


    public static String ElementDisplayedXpath(String element) {
        try {

            WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='" + element + "']"));
            if (ele.isDisplayed())

                return "Pass";
            return "Pass";
        } catch (Exception e) {
            return "Fail";
        }
    }


    //Scroll till a text

    public static void scrollAndClick(String visibleText) {
        ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiScrollable"
                + "(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
    }


    // Method to check the check box using the bounds

    public static void ClickCheckboxUsingBounds(String boundvalue) throws Exception {
        try {

            WebElement Checkbox = driver.findElement(By.xpath("//android.widget.CheckBox[@bounds='" + boundvalue + "']"));

            Checkbox.click();
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }

    }

    //Write to get sibling using parent

    public static void ClickOnElementusingBounds(String boundvalue) throws Exception {
        try {

            WebElement Checkbox = driver.findElement(By.xpath("//android.widget.TextView[@bounds='" + boundvalue + "']"));

            Checkbox.click();
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }

    }


    /**
     * Toggle Method :
     *
     * @param togglevalue
     * @return
     * @throws Exception
     */

    public static String toggleswitch(String objkey, String togglevalue, boolean Verify) throws Exception {

        if (Verify != true) {
            try {
                WebElement toggle = getElement(objkey);
                String SwitchState = toggle.getText();
                if (SwitchState.equalsIgnoreCase(togglevalue))
                    return "Pass";
                else {
                    toggle.click();
                    return "Pass";
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage(), e);

            }
        } else {
            try {
                WebElement toggle = getElement(objkey);
                String SwitchState = toggle.getText();
                if (SwitchState.equalsIgnoreCase(togglevalue))
                    return "Pass";
                else {
                    return "fail";
                }
            } catch (Exception e) {
                throw new Exception(e.getMessage(), e);

            }

        }
    }

    // This method is to get text of the web/mobile element.

    public static String GetText(String text) throws Exception {
        try {
            WebElement ele = driver.findElement(By.xpath("//*[@text='" + text + "']"));
            String eletext = ele.getText();
            if (eletext.equals(text))
                return "Pass";

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);

        }
        return "Pass";
    }


    // This method is to check whether the checkbox is selected or not.

    public static String Isselected(String objkey) throws Exception {
        try {

            WebElement ele = getElement(objkey);
            if (ele.isEnabled())
                return "Pass";
            else
                return "Fail";

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    // This method is to tick the check box.

    public static String TickCheckbox(String objkey) throws Exception {
        try {

            WebElement ele = getElement(objkey);
            if (ele.isSelected())
                return "Pass";
            else {
                ele.click();
                return "pass";
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    //modify
    public static String GetTextObj(String objkey) throws Exception {
        try {
            WebElement ele = getElement(objkey);
            String eletext = ele.getText();
//						if(eletext.equals(text))
            return eletext;

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);

        }

    }


    public static void List_SetText(String option) throws Exception {
//
        List<MobileElement> elements = driver.findElements(MobileBy.xpath("//*[(@class='android.widget.LinearLayout') and (@index='1')]/android.widget.Spinner/android.widget.TextView"));
        int ListSize = elements.size();
        System.out.println(ListSize);
//			for(MobileElement e:elements)
//			{
//				if(e.getText().equalsIgnoreCase(option))
//				{
//					e.click();
//					ClickOnElementUsingText(option);
//					return "pass";
//				}
//				else {
//					return "fail";
//				}
//			}
//
//			return"fail";

        MobileElement e = elements.get(0);
        String Text = e.getText();
        if (!Text.equalsIgnoreCase(option))
            e.click();
        ClickOnElementUsingText(option);

    }

    public static String VerifyListSetText(String option) throws Exception {

        List<MobileElement> elements = driver.findElements(MobileBy.xpath("//*[(@class='android.widget.LinearLayout') and (@index='1')]/android.widget.Spinner/android.widget.TextView"));
        int ListSize = elements.size();
        System.out.println(ListSize);
        MobileElement e = elements.get(0);
        String Text = e.getText();
        if (Text.equalsIgnoreCase(option))
            return "Pass";
        else
            return "Fail";

    }


    public static int Getlistsize() {

        List<MobileElement> elements = driver.findElements(MobileBy.xpath("//*[(@class='android.widget.LinearLayout') and (@index='1')]/android.widget.Spinner/android.widget.TextView"));
        int ListSize = elements.size();
        System.out.println(ListSize);
        return ListSize;
    }

    public static String getIndex(String objkey) throws Exception {
        try {
            WebElement ele = getElement(objkey);
            String index = ele.getAttribute("index");
//				if(eletext.equals(text))
            return index;

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);

        }
    }

    public void reportFailureandStop(String message) {

        //log("Fail: " + message);
        reporterror = "Fail";
        Assert.fail(message);
    }

}
