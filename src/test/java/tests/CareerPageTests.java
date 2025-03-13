package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;

public class CareerPageTests extends BaseTest {
    @Test
    public void checkCareerPage () {

        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage(driver);
        homePage.goToCareersPage(driver);

        CareersPage careersPage = new CareersPage(driver);
        Assert.assertTrue(careersPage.isCareerPageDisplayed());

        Assert.assertTrue(careersPage.isTeamBlockDisplayed());
        Assert.assertTrue(careersPage.isLocationBlockDisplayed());
        Assert.assertTrue(careersPage.isCareerPageDisplayed());
    }
}
