package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomepageTests extends BaseTest {
    @Test
    //Checks the homepage
    public void homepageCheck() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage(driver);
        Assert.assertTrue(homePage.isHomepageDisplayed());
    }

}
