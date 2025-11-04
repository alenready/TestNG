package org.ictkerala.test.testcases;

import org.practice.testautomation.base.TestBase;
import org.practice.testautomation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Invalid extends TestBase {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void invalidUsernameTest() {
        loginPage.enterUsername("incorrectUser");
        loginPage.enterPassword("Password123");
        loginPage.clickSubmit();

        Assert.assertTrue(driver.getPageSource().contains("Your username is invalid!"),
                "Expected error message not found!");
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
