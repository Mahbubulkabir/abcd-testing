package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.RadioBtn;

public class RadioTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(RadioBtn.class.getName());
    @Test
    public void radioMethod() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.setEmailField("hemalhemu7@gmail.com");
        loginPage.setPassword("Hemal1703");
        loginPage.setLoginButton();

        RadioBtn radioBtn = new RadioBtn(getDriver());
        radioBtn.setClickOnEmailBtn();
        radioBtn.setClickOnRadioBox();
        Thread.sleep(3000);
        Assert.assertEquals(getCurrentTitle(),"Cogmento CRM");
        LOG.info("radio button page validation success");
    }
}