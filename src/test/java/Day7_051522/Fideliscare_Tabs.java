package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Fideliscare_Tabs {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with Web Driver Manager
        WebDriverManager.chromedriver().setup();
        //set Chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set incognito mode
        options.addArguments("incognito mode");
        //for mac use fullscreen
        options.addArguments("start-fullscreen");
        //define Web driver I am using
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(3000);
        //click on shop for a plan. We are using elements because there is more than one option available
        driver.findElements(By.xpath("//*[text()='Shop For a Plan']")).get(0).click();
        Thread.sleep(1000);
        //click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text()='Medicaid Managed Care']")).get(0).click();
        Thread.sleep(1000);
        //click on search under find a doctor card
        driver.findElement(By.xpath("//*[@href='/findadoctor']")).click();
        Thread.sleep(1000);
        //store new tabs in an Array list using getWindowHandles method
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new window. It should be index one
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);

        //click on new search button
        driver.findElement(By.xpath("//*[@class = 'fal fa-search-plus']")).click();
        Thread.sleep(1000);
        //close the tab
        driver.close();

        //switch back to default tab
        driver.switchTo().window(tabs.get(0));
        //click on providers card
        driver.findElement(By.xpath("//*[@class='fal fa-stethoscope fa-fw']")).click();
        Thread.sleep(3000);

        //quit the driver
        driver.quit();

    }//end of main

}//emd of java class
