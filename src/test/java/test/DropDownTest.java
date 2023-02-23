package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.LogInPage;

public class DropDownTest extends CommonAPI {

    Logger LOG= LogManager.getLogger(DropDownTest.class.getName());
    @Test
    public void testMethod() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.setEmailField("hemalHemu7@gmail.com");

        loginPage.setPassword("Hemal1703");

        loginPage.setLoginButton();


        DropDownPage dropDownPage = new DropDownPage(getDriver());
        dropDownPage.setMenuBar();
        Thread.sleep(5000);
        dropDownPage.setImpotBar();
        Thread.sleep(5000);
        Assert.assertEquals(getCurrentTitle(),"Cogmento CRM");
        LOG.info("DropDown validation successful");

    }

}
