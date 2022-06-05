package Day6_051422;

//import ReusableLibraries.automationPrerequisites;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findElementsExample {

    public static void main(String[] args) throws InterruptedException {
        //call webdriver pre requisites
        //automationPrerequisites.preRequisites();

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

        //navigate to bing home
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);
        //click on images using class property with index of 1
        //to ignore white space in the property value we use contains command in xpath
        driver.findElements(By.xpath("//li[contains(@class, 'scope')] ")).get(0).click();

        //close the driver
        driver.quit();


    }//end of main
}//end of java class
