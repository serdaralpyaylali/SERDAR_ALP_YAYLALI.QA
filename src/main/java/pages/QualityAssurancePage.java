package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage {
    public WebDriver driver;
    private By acceptAllCookiesButton = By.xpath("//*[@id='wt-cli-accept-all-btn' and contains(text(), 'Accept All')]");
    private By seeAllQAJobsButton = By.xpath("//a[contains(@href, 'careers/open-positions') and contains(text(), 'See all QA jobs')]");

    public QualityAssurancePage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToQualityAssurancePage(WebDriver driver) {
        driver.get("https://useinsider.com/careers/quality-assurance/");
    }
    public void acceptAllCookies() {
        driver.findElement(acceptAllCookiesButton).click();
    }
    public void seeAllQAJobs() {
        driver.findElement(seeAllQAJobsButton).click();
    }



}
