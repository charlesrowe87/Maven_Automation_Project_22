package Day9_052222;

import ReusableLibraries.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Automation_AI05 {
    public static void main(String[] args) {
       //set the local driver to reusable set driver
        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to UHC
        driver.navigate().to("https://www.uhc.com");

        //create array list for first names
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Charlie");
        firstName.add("Dee");
        firstName.add("Brian");
        //create array list for last name
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Rowe");
        lastName.add("Smith");
        lastName.add("Oliver");
        //create array list for birth month
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("June");
        birthMonth.add("August");
        birthMonth.add("December");
        //create array list for birthday
        ArrayList<String> birthday = new ArrayList<>();
        birthday.add("08");
        birthday.add("12");
        birthday.add("15");
        //create array list for birth year
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1981");
        birthYear.add("1984");
        birthYear.add("1987");
        //create array list for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11213");
        zipCode.add("11226");
        zipCode.add("11238");
        //create array list for member ID
        ArrayList<String> memberID = new ArrayList<>();
        memberID.add("123456");
        memberID.add("234567");
        memberID.add("345678");

            //verify title name using title contains method-this is case sensitive
            Reusable_Actions.titleContainsAction(driver, "Health insurance plans");
        for (int i = 0; i < firstName.size(); i++){
            //click on "find a doctor" link using reusable method
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a doctor");
            //click on sign in button
            Reusable_Actions.clickAction(driver, "//*[@aria-label='Sign in menu']", "sign in button");
            //click on Medicare Plan
            Reusable_Actions.clickAction(driver, "//*[text()='Medicare plan?']", "Medicare Plan button");
            //switch tab using reusable method
            Reusable_Actions.switchTabByIndexAction(driver, 1, "Switch to second tab");
            //test switch tab using scroll method
            //Reusable_Actions.scrollAction(driver,"scroll(0,400)");

            //click on register now button
            Reusable_Actions.clickAction(driver, "//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn ng-scope']", "Register Now button");
            //enter first name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='firstName']", firstName.get(i), "first name");
            //enter last name
            Reusable_Actions.sendKeysAction(driver, "//*[@id='lastName']", lastName.get(i), "last name");
            //click on birth month drop down
            //Reusable_Actions.clickAction(driver,"//*[@id='dob_month_input']","Birth month dropdown");
            //select birth month
            Reusable_Actions.selectByTextAction(driver, "//*[@name='dob_month']",birthMonth.get(i), "birth month");
            //enter birthday
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_day']", birthday.get(i), "birthday");
            //enter birth year
            Reusable_Actions.sendKeysAction(driver, "//*[@id='dob_year']", birthYear.get(i), "birth year");
            //enter zip code
            Reusable_Actions.sendKeysAction(driver, "//*[@id='zipCode']", zipCode.get(i), "zip code");
            //enter member ID
            Reusable_Actions.sendKeysAction(driver, "//*[@id='memberId']", memberID.get(i), "member ID");
            //click on continue button
            Reusable_Actions.clickAction(driver, "//*[@id='submitBtn']", "Continue button");
            //capture error message using get text and print it
            Reusable_Actions.getTextAction(driver, "//*[@id='personalInfo_errors']", "Error message");
            String errorMessage = driver.findElement(By.xpath("//*[@id='personalInfo_errors']")).getText();
            System.out.println("The error for " + firstName.get(i) + " is " + errorMessage);

        //close the driver
        driver.close();
        //switch back to default tab
        Reusable_Actions.switchTabByIndexAction(driver,0,"Switch to default tab");
        }//end of for loop

        //quit the driver
        //driver.quit();

    }//end of main
}//end of class
