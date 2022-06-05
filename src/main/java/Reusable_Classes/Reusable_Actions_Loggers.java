package Reusable_Classes;

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

import static Reusable_Classes.Reusable_Actions_POM_Loggers.getScreenShot;

public class Reusable_Actions_Loggers {

    //set a static timeout variable so that it can cover all explicit wait time for all methods
    public static int timeout = 40;

    //resuable function for webdriver as a return method
    public static WebDriver setDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("start-fullscreen");
        //set condition for headless
        //options.addArguments("headless");
        //define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of setDriver method

    //create a mouse hover method
    public static void mouseHover(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully hover on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to hover on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of mouseHover

    //create a click method
    public static void clickAction(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS,"Successfully click on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of clickAction

    //create a submit method
    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit

    //create a sendkeys method
    public static void sendKeysAction(WebDriver driver,String xpath, String userValue, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of sendkeys method

    //create a getText method
    public static String getTextAction(WebDriver driver,String xpath,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = "";
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully capture text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
        return result;
    }//end of getTextAction method

    //create a getText method by index
    public static String getTextByIndexAction(WebDriver driver,String xpath, int indexNumber,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String result = null;
        logger.log(LogStatus.PASS,"Successfully capture text by index on element " + elementName);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text by index " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to get text by index " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
        return result;
    }//end of getText method by index

    //create a click by index method
    public static void clickByIndexAction(WebDriver driver,String xpath, int indexNumber,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            logger.log(LogStatus.PASS,"Successfully click on element by index " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element by index " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element by index " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of clickByIndexAction

    public static void selectByTextAction(WebDriver driver,String xpath,String textValue,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select elementDropdown = new Select(element);
            elementDropdown.selectByVisibleText(textValue);
            logger.log(LogStatus.PASS,"Successfully select element by text " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to select on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to select on element " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of select by text Action method

    //create a scroll method
    public static void scrollAction(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(xpath);
            logger.log(LogStatus.PASS,"Successfully able to scroll " + elementName);

        } catch (Exception e) {
            System.out.println("Unable to scroll " + elementName + e);
            logger.log(LogStatus.FAIL,"Unable to scroll " + elementName + e);
            getScreenShot(driver,elementName,logger);
        }//end of try and catch

    }//end of scrollAction

    //create a scroll into element method
    public static void scrollToElementAction(WebDriver driver,String xpath,ExtentTest logger,String elementName){
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //declare a webelement you want to scroll into
            WebElement element = driver.findElement(By.xpath(xpath));
            jse.executeScript("arguments[0].scrollIntoView(true);",element);
            logger.log(LogStatus.PASS,"Successfully scroll into element " + elementName);

        } catch (Exception e){
            System.out.println("Unable to scroll to element " + elementName + e);
            logger.log(LogStatus.FAIL,"Unable to scroll to element " + elementName + e);
            getScreenShot(driver,elementName,logger);
        }//end of try and catch

    }//end of scrollToElementAction

    public static void getTitleAction(WebDriver driver,ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        String actualTitle = driver.getTitle();
        logger.log(LogStatus.PASS,"My title is " + elementName);

        if (actualTitle.equals(elementName)) {
            System.out.println("My title matches");
            logger.log(LogStatus.PASS,"My title matches " + elementName);
        } else {
            System.out.println("Title does not match, actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Title does not match, actual title is " + actualTitle);
            getScreenShot(driver,elementName,logger);
        }//end of if else statement
    }//end of getTitleAction method

    //create titleContains method
    public static void titleContainsAction(WebDriver driver,ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String actualTitle = driver.getTitle();
        logger.log(LogStatus.PASS,"My title contains " + elementName);

        if (actualTitle.contains(elementName)) {
            System.out.println("My title contains " + elementName);
        } else {
            System.out.println("Title does not contain " + elementName + " , actual title is " + actualTitle);
            logger.log(LogStatus.FAIL,"Title does not contain " + elementName + " , actual title is " + actualTitle);
            getScreenShot(driver,elementName,logger);
        }//end of if else statement
    }//end of title contains method

    //create boolean method
    public static void verifyStatusOfElement(WebDriver driver, String xpath, Boolean expectedStatus, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            Boolean actualStatus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
            if(expectedStatus == actualStatus){
                logger.log(LogStatus.PASS,"Element is selected as expected");
            } else {
                logger.log(LogStatus.FAIL,"Element is not selected");
            }
        } catch (Exception e) {
            System.out.println("Unable to verify status " + elementName + e);
            getScreenShot(driver,elementName,logger);
        }//end of try and catch
    }//end of verify status method





}//end of class
