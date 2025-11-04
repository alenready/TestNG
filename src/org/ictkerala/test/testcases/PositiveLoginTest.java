package org.ictkerala.test.testcases;


//import org.practice.testautomation.base.TestBase;
//import org.practice.testautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    LoginPage loginPage;

    // Locator for Logout button
    By logoutButton = By.xpath("//a[contains(text(),'Log out')]");

    @BeforeMethod
    public void setUpTest() {
        setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.enterUsername("student");
        loginPage.enterPassword("Password123");
        loginPage.clickSubmit();

        // URL Verification
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("practicetestautomation.com/logged-in-successfully/"),
                "URL does not contain expected text after login!");

        // Content Verification
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Congratulations") || pageSource.contains("successfully logged in"),
                "Page does not contain expected success message!");

        // Logout Button Verification
        try {
            WebElement logoutBtn = driver.findElement(logoutButton);
            Assert.assertTrue(logoutBtn.isDisplayed(), "Log out button is not displayed!");
            System.out.println(" Log out button is successfully displayed after login!");
        } catch (NoSuchElementException e) {
            Assert.fail(" Log out button is not found on the page!", e);
        }
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}




