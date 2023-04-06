package com.orangehrm.test;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.pages.LogInPage;
import com.orangehrm.pages.PostComments;
import com.orangehrm.pages.MostLikePost;
import utility.ReadFromExcel;

public class TestMostLikePost extends CommonAPI {
    Logger LOG = LogManager.getLogger(TestMostLikePost.class.getName());
    ReadFromExcel read = new ReadFromExcel("C:\\Users\\munna\\InteliiJ\\abcd-GitHub-test-project\\data\\data.xlsx", "test data");
    String username= read.getCellValueForGivenHeaderAndKey("key","userName");
    String password= read.getCellValueForGivenHeaderAndKey("key","passWord");
    @Test
    public void mostLikePostButtonClick() throws InterruptedException {
        MostLikePost mostLikePost = new MostLikePost(getDriver());
        PostComments postComments = new PostComments(getDriver());
        LogInPage logInPage = new LogInPage(getDriver());
        String expectedHomePageTitle = "OrangeHRM";
        String actualHomePageTitle = getCurrentTitle();
        Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle);
        LOG.info("land to orangehrm home page successfully");
        logInPage.typeUserName(username);
        logInPage.typePassword(password);
        logInPage.setClickOnLogInBtm();
        postComments.setClickOnBuzzBtn();
        Thread.sleep(3000);
        mostLikePost.setClickOnShareLikeBtn();
        String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz";
        Assert.assertEquals(getURL(), expectedUrl);
        LOG.info("share post page validation successful");

    }
}
