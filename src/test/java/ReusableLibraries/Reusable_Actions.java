package ReusableLibraries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions {

    //set a static timeout variable so that it can cover all explicit wait time for all methods
    public static int timeout = 30;

    public static WebDriver setDriver(){
        //set up your chromedriver with Webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set Chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the option as incognito mode
        options.addArguments("incognito");
        //set the option to fullscreen/maximized
        //options.addArguments("start-maximized");
        //for mac use fullscreen
        options.addArguments("start-fullscreen");
        //set the option as headless
        //options.addArguments("headless")
        //define webdriver I am using
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickAction

    //create a submit method
    public static void submitAction(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
        }
    }//end of submitAction

    //create a scroll method
    public static void scrollAction(WebDriver driver, String xpath, String elementName){
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(xpath);

        } catch (Exception e) {
            System.out.println("Unable to scroll " + elementName + e);
        }//end of try and catch

    }//end of scrollAction

    //create a scroll into element method
    public static void scrollToElementAction(WebDriver driver,String xpath,String elementName){
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //declare a webelement you want to scroll into
            WebElement element = driver.findElement(By.xpath(xpath));
            jse.executeScript("arguments[0].scrollIntoView(true);",element);

        } catch (Exception e){
            System.out.println("Unable to scroll to element " + elementName + e);
        }//end of try and catch

    }//end of scrollToElementAction

    //create a send keys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of send keys method

    //create a getText method
    public static String getTextAction(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
        }
        return result;
    }//end of getTextAction method

    //create a getText method by index
    public static String getTextByIndexAction(WebDriver driver,String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text by index " + elementName + " " + e);
        }
        return result;
    }//end of getText method by index

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
        }
    }//end of clickByIndexAction

    public static void selectByTextAction(WebDriver driver,String xpath,String textValue,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
           Select elementDropdown = new Select(element);
           elementDropdown.selectByVisibleText(textValue);

        } catch (Exception e) {
            System.out.println("Unable to select on element " + elementName + " " + e);
        }
    }//end of select Action method

    //create a click by index method
    public static void switchTabByIndexAction(WebDriver driver, int indexNumber, String elementName) {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(indexNumber));
        }//end of click by index method

    public static void getTitleAction(WebDriver driver,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(elementName)) {
                System.out.println("My title matches");
        } else {
                System.out.println("Title does not match, actual title is " + actualTitle);
            }
    }//end of getTitleAction method

    //create titleContains method
    public static void titleContainsAction(WebDriver driver,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(elementName)) {
            System.out.println("My title contains " + elementName);
        } else {
            System.out.println("Title does not contain " + elementName + " , actual title is " + actualTitle);
        }
    }//end of title contains method

    //create boolean method
    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if(expectedStatus == actualStatus){
                System.out.println("Element is selected as expected");
            } else {
                System.out.println("Element is not selected");
            }
        } catch (Exception e) {
            System.out.println("Unable to verify status " + elementName + e);
            }//end of try and catch
        }//end of verify status method




}//end of class
