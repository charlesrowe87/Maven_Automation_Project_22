package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class USPS_Implicit_Explicit {
    public static void main(String[] args) {
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

        //set your global implicit wait
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //navigate to USPS
        driver.navigate().to("https://www.usps.com");

        //define mouse action
        Actions actions = new Actions(driver);

        //declare and define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,8);


        //hover to quick tools
        WebElement quickTools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")));
        actions.moveToElement(quickTools).perform();

        //click on track a package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();

        //click on tracking field and enter incorrect tracking number using mouse actions
        WebElement packageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")));
        packageField.click();
        packageField.sendKeys("243547584y34");

    }//end of main
}//end of class
