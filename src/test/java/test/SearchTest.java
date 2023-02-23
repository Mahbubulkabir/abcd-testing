package test;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.SearchPage;

public class SearchTest extends CommonAPI {
    @Test
    public void testMethod() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.setEmailField("hemalHemu7@gmail.com");
        loginPage.setPassword("Hemal1703");
        loginPage.setLoginButton();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.setSearchBox("contact");
        Thread.sleep(3000);

    }


}
