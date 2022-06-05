package Day8_052122;

import Day3_043022.If_else_condition;
import ReusableLibraries.Reusable_Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
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

        driver.navigate().to("https://www.google.com");

        //capture title of page and compare it with actual title 'GOOGLE'
        /*String actualTitle = driver.getTitle();
        if (actualTitle.equals("Google")){
            System.out.println("My title matches");
        }else {
            System.out.println("Title does not match, actual title is " + actualTitle);
        }*/

    }//end of main
}//end of class
