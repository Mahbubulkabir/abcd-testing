package test;

import base.CommonAPI;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.LogOut;

@Test
public class LogOutTest extends CommonAPI {

    public void logoutMethod() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.setEmailField("hemalhemu7@gmail.com");
        loginPage.setPassword("Hemal1703");
        loginPage.setLoginButton();

        LogOut logOut = new LogOut(getDriver());
        logOut.setLogOutBtn();
        Thread.sleep(5000);

    }

}
