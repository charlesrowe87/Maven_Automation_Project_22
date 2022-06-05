package Day9_052222;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class USPS_Reusable_Concepts {
    public static void main(String[] args) {

        //set the local driver to reusable setDriver method
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to USPS
        driver.navigate().to("https://www.usps.com");

        //hovering to quick tools
        Reusable_Actions.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        //hover to send tab
        Reusable_Actions.mouseHover(driver,"//*[@id='mail-ship-width']","Send Tab");

        //click on calculate a price
        Reusable_Actions.clickAction(driver,"//*[@class='tool-calc']","Calculate a Price");

        //enter the zip code
        Reusable_Actions.sendKeysAction(driver,"//*[@id='Origin']","11218","Zip code");

        //print out header text info
        String result = Reusable_Actions.getTextAction(driver,"//*[@class='header-usps row']","Header Info");
        System.out.println("My header info is " + result);



    }//end of main

}//end of class
