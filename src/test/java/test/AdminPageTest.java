package test;
import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LogInPage;
import utility.ReadFromExcel;


public class AdminPageTest extends CommonAPI {
    Logger LOG = LogManager.getLogger(AdminPageTest.class.getName());
    String Field="Admin";
    ReadFromExcel read = new ReadFromExcel("C:\\Users\\munna\\InteliiJ\\abcd-GitHub-test-project\\data\\data.xlsx", "test data");
    String username= read.getCellValueForGivenHeaderAndKey("key","userName");
    String password= read.getCellValueForGivenHeaderAndKey("key","passWord");
    @Test
    public void ChangePasswordCheckBox(){
        LogInPage logInPage = new LogInPage(getDriver());
        String expectedHomePageTitle = "OrangeHRM";
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle);
        LOG.info("land to orangehrm home page successfully");
        logInPage.typeUserName(username);
        logInPage.typePassword(password);
        logInPage.setClickOnLogInBtm();
        String expectedUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(getURL(), expectedUrl);
        LOG.info("login page validation success");

        AdminPage adminpage = new AdminPage(getDriver());
        adminpage.setCliciOnAdmin();
        adminpage.typeUserName("Admin");
        adminpage.userRoleDropDown();
        adminpage.statusDropDown();
        adminpage.clickSearch();
        adminpage.clickOnEdit();

        Assert.assertTrue(adminpage.clickOnCheckBox());
        LOG.info("change password check box test finished");
    }
    @Test
    public void AddJobTitle() {
        LogInPage logInPage = new LogInPage(getDriver());
        String expectedHomePageTitle = "OrangeHRM";
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle);
        LOG.info("land to orangehrm home page successfully");
        logInPage.typeUserName(username);
        logInPage.typePassword(password);
        logInPage.setClickOnLogInBtm();
        String expectedUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(getURL(), expectedUrl);
        LOG.info("login page validation success");

        AdminPage adminpage = new AdminPage(getDriver());
        adminpage.setCliciOnAdmin();
        adminpage.jobTitleFromDropDown();
        adminpage.clickOnAddBtn();
        adminpage.typeJobTitle("Automation Engineer");
        adminpage.addJobDescription("I am QA engineer");
        adminpage.typeNote("This is Selenium");
        adminpage.clickOnSave();

//        String ActualResult1= adminpage.ToastMessage();
//        Assert.assertEquals(ActualResult1, "Successfully Saved");
//        LOG.info("Job Title successfully Added");
        LOG.info("Add Job Title test Finished");
    }

}