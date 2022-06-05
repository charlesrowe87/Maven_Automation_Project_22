package Day10_052822;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Example_DependsOnMethod {
    //declare the local driver
    WebDriver driver;
    //before suite will set the driver you are usin
    @BeforeSuite
    public void setChromeDriver() {
        driver = Reusable_Actions.setDriver();
    }//end of before suite annotation

    //test case 1. Navigate to google and enter keyword
    @Test(priority = 1)
    public void searchForKeyWord() {
        driver.navigate().to("https://www.google.com");
        //enter a key word on search field
        Reusable_Actions.sendKeysAction(driver,"//*[@name='q']","BMW","search field");
        //Submit the google button
        Reusable_Actions.submitAction(driver,"//*[@name='btnK']","Google searcb button");
    }//end of test 1

    /*
    dependsOnMethods used when  following @Test is dependent on previous @Test method. Then If the first test fails,
    the dependent test will get skipped
     */
    @Test(dependsOnMethods = "searchForKeyWord")
    public void CaptureSearchNumber(){
        //capture search result
        String result = Reusable_Actions.getTextAction(driver,"//*[@id='result-stats']","Search Result Text");
        //split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        //print out search result
        System.out.println("Search number is " + arrayResult[1]);
    }//end of test 2

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite



}//end of class
