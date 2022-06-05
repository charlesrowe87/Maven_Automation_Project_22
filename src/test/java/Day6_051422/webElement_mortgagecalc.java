package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class webElement_mortgagecalc {

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

        //click, clear and enter new value on home field
        WebElement homeValue = driver.findElement(By.xpath("//*[@id= 'homeval']"));
        homeValue.click();
        homeValue.clear();
        homeValue.sendKeys("450000");

        //click on % radio button
        driver.findElement(By.xpath("//*[@value='percent']")).click();

        //click, clear and enter data on down payment field
        WebElement downPayment = driver.findElement(By.xpath("//*[@id ='downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys("5");

    }//end of main
}//end of java class
