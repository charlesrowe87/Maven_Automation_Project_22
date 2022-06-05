package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome_Options_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        //set up your chromedriver with webdrivermanager
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

        //go to Google home page
        driver.navigate().to("https:www.google.com");
        Thread.sleep(3000);

        //maximize the driver
        driver.manage().window().fullscreen();//or use .window().maximize();

        //locate element for search field and type keyword "cars"
        driver.findElement(By.xpath("//*[@name= 'q']")).sendKeys("cars");

        //submit on google search button
        driver.findElement(By.xpath("//*[@name= 'btnK']")).submit();

        //capture the google search and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Result is" + searchResult);

        //extract number and print only search number only
        String[] arrayResult = searchResult.split(" ");

        //to replace ( and ) from the seconds that's coming from arrayList[3] use .replace command to replace it with ""(no space)
        String replaceParanth = arrayResult[3].replace("(","").replace(")","");

        System.out.println("My search number is " + arrayResult[1]);


        //quit the driver
        driver.quit();


    }//end of main

}//end of java class
