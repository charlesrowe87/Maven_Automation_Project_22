package Page_Objects;

import Reusable_Classes.Reusable_Annotations_Loggers;
import Reusable_Classes.Reusable_Annotations_Loggers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Reusable_Classes.Reusable_Annotations_Loggers.driver;

public class BaseClass extends Reusable_Annotations_Loggers {
    public BaseClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//end of constructor class

    //create static reference for google home page
    public static GoogleHomePage googleHomePage(){
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        return  googleHomePage;
    }//end of googleHomePage method

    //create static reference for google search result page
    public static GoogleSearchResultPage googleSearchResultPage(){
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        return  googleSearchResultPage;
    }//end of googleSearchResultPage method


}
