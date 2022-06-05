package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AI_Hotels {
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

        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(3000);

        //create array list for selecting location
        ArrayList<String> goingTo = new ArrayList<>();
        goingTo.add("Los Angeles");
        goingTo.add("Hawaii");
        goingTo.add("Las Vegas");

        //create array list for check in dates
        ArrayList<String> checkinDate = new ArrayList<>();
        checkinDate.add("June 4th");
        checkinDate.add("June 5th");
        checkinDate.add("June 6th");

        //create array list for check out dates
        ArrayList<String> checkoutDate = new ArrayList<>();
        checkoutDate.add("June 11th");
        checkoutDate.add("June 12th");
        checkoutDate.add("June 13th");

        //create an array list for number of travelers
        ArrayList<String> nmbrofTravelers = new ArrayList<>();
        nmbrofTravelers.add("2");
        nmbrofTravelers.add("3");
        nmbrofTravelers.add("4");
        //for (int i = 0; i < goingTo.size(); i++) {
        try {
            WebElement searchLocation = driver.findElement(By.xpath("//*[@id='location-field-destination-menu']"));
            searchLocation.click();
            searchLocation.clear();
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("My location is " + e);
        }
        try {
            WebElement tripDestination = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
            tripDestination.click();
            //tripDestination.clear();
            tripDestination.sendKeys("Los Angeles");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("I can't enter my location " + e);
        }

            try {
                driver.findElement(By.xpath("//*[@aria-label='Los Angeles']")).click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to click first suggestion " + e);
            }
                //handle exception for selecting check in date
                try {
                driver.findElement(By.xpath("//*[@id='d1-btn']")).click();
                    Thread.sleep(1000);
                    WebElement intialDate = driver.findElement(By.xpath("//*[@id='d1-btn']"));
                    intialDate.click();
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//*[@aria-label= 'June 7,2022']")).click();

                } catch (Exception e) {
                    System.out.println("Unable to select check in date " + e);
                }//end of select check in date exception
        //handle exception for selecting check out date
        try {
            driver.findElement(By.xpath("//*[@id='d2-btn']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='d2-btn']"));
        } catch (Exception e) {
            System.out.println("Unable to select check out date " + e);
        }//end of select check out date exception






        //}//end of exception for pick location

        //}//end of for loop

        //quit the driver
        //driver.quit


    }//end of main
}//end of class
