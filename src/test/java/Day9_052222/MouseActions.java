package Day9_052222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException {
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

        //navigate to USPS
        driver.navigate().to("https://www.usps.com");

        //define mouse action
        Actions mouseActions = new Actions(driver);

        //hover to send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        //click on tracking using mouse actions
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();
        //add some wait time
        Thread.sleep(2000);

        //click on tracking field and enter incorrect tracking number using mouse actions
        WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("243547584y34").perform();

    }//end of main
}//end of class
