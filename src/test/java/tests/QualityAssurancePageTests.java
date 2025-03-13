package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenPositions_QualityAssurancePage;
import pages.QualityAssurancePage;


public class QualityAssurancePageTests extends BaseTest {
    @Test
    public void checkCareerPage () {
        QualityAssurancePage qualityAssurancePage = new QualityAssurancePage(driver);
        qualityAssurancePage.goToQualityAssurancePage(driver);
        qualityAssurancePage.acceptAllCookies();
        qualityAssurancePage.seeAllQAJobs();

        OpenPositions_QualityAssurancePage opqaPage = new OpenPositions_QualityAssurancePage(driver);
        Assert.assertTrue(opqaPage.isOpenPositionPageDisplayed(), "Page URL is not correct");

        opqaPage.clickFilterByQualityAssurance();
        opqaPage.clickFilterByLocationsDropdown();
        opqaPage.clickIstanbulOption();

        Assert.assertTrue(opqaPage.isJobListNotEmpty(),"No Result Found");
        Assert.assertTrue(opqaPage.checkPosition(),"Some job positions do not include 'Quality Assurance'");
        Assert.assertTrue(opqaPage.checkDepartment(),"Some departments do not include 'Quality Assurance'");
        Assert.assertTrue(opqaPage.checkLocation(),"Some locations do not include 'Istanbul'");

        opqaPage.clickViewRole();
        Assert.assertTrue(opqaPage.checkRedirect().contains("jobs.lever.co"));
    }
}


