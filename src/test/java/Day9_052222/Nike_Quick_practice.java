package Day9_052222;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class Nike_Quick_practice {
    public static void main(String[] args) {
        //declare driver with reusable method
        WebDriver driver = Reusable_Actions.setDriver();
        driver.navigate().to("https://www.nike.com");
        //hover mouse over featured
        Reusable_Actions.mouseHover(driver,"//*[@aria-label='New & Featured']","featured");
        //click on Best of Air Max function
        Reusable_Actions.clickAction(driver,"//*[@aria-label='main-menu, New & Featured, New & Featured, Best of Air Max']","Best of AIr Max");

    }//end of main
}//end of class
