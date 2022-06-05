package Day12_060422;

import Page_Objects.BaseClass;
import Reusable_Classes.Reusable_Annotations_Loggers;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends Reusable_Annotations_Loggers {

    @Test
    public void SearchForAKeywordOnGoogleHome(){
        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();
    }

    @Test(dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle(){
        BaseClass.googleSearchResultPage().CaptureSearchNumberAndPrintIt();
    }


}
