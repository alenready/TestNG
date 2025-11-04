package org.ictkerala.test.testcases;


import org.openqa.selenium.WebDriver;
import java.time.Duration;
public class Logout {

private Object logoutButton;
WebElement logoutBtn = driver.findElement(logoutButton);
Assert.assertTrue(logoutBtn.isDisplayed(), "Log out button is not displayed!");

}
}