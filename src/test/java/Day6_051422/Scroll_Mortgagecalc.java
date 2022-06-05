package Day6_051422;

import ReusableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;

public class Scroll_Mortgagecalc {

    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set Chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set incognito mode
        options.addArguments("Incognito mode");
        //for mac use fullscreen
        options.addArguments("start-fullscreen");
        //define webdriver I am using
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calculator home
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        Reusable_Actions.scrollAction(driver,"scroll(0,800)","scroll down");

        /*declare javascript executor variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll to pixel 800 on mortgage calc website
        jse.executeScript("scroll(0,800)");
        //wait for a bit for browser to perform scrolling
        Thread.sleep(2000);

        //Reusable_Actions.scrollToElementAction(driver,"//*[@id='share_button']","Share Button");
        /*declare a web element variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
        //scroll into share this button
        jse.executeScript("arguments[0].scrollIntoView(true);", shareButton);
        Thread.sleep(2000);
        //click on the share this calculation button
        shareButton.click();
        Thread.sleep(2000);
        //scroll back up
        jse.executeScript("scroll(0,-800)");*/
        Thread.sleep(2000);
        //quit the chrome driver
        //driver.quit();

    }//end of main
}//end of class
