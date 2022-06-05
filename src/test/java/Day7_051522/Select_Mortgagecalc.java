package Day7_051522;

import ReusableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_Mortgagecalc {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set Chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set incognito mode
        options.addArguments("incognito mode");
        //for mac use fullscreen
        options.addArguments("start-fullscreen");
        //define Web driver I am using
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        //Reusable_Actions.selectAction(driver,"//*[@name='param[start_month]']","Jun","Start Month");

        //select start month from dropdown box
        WebElement startMonth = driver.findElement(By.xpath("//select[@name='param[start_month]']"));
        //define select command
        Select dropDown = new Select(startMonth);
        //select by visible text
        dropDown.selectByVisibleText("Jun");

        //clicking on dropdown and its value if dropdown is not under select tag
        startMonth.click();
        //click on the value of the start month
        driver.findElement(By.xpath("//*[text='Jun']")).click();

        //select loan type from the dropdown
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        Select loanTypeDropdown = new Select(loanType);
        //select by visible text
        loanTypeDropdown.selectByVisibleText("FHA");

        //quit the driver
        //driver.quit();

    }//end of main

}//end of java class
