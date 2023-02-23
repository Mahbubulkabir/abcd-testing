package test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.Calendar;
import pages.LogInPage;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class CalendarTest extends CommonAPI {


    Logger LOG= LogManager.getLogger(CalendarTest.class.getName());
    @Test
    public void testCalendar() throws InterruptedException {
        LogInPage loginPage = new LogInPage(getDriver());
        loginPage.setEmailField("hemalhemu7@gmail.com");
        loginPage.setPassword("Hemal1703");
        loginPage.setLoginButton();


        Calendar calendar = new Calendar(getDriver());
        calendar.setCalendar();
        calendar.setChangeDate();
        Thread.sleep(3000);


    }  }
