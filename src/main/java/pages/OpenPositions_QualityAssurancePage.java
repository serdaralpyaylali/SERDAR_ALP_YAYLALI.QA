package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpenPositions_QualityAssurancePage {
    public WebDriver driver;
    private WebDriverWait wait;
    private By filterByLocationsDropdown = By.id("select2-filter-by-location-container");
    private By filterByQualityAssurance = By.xpath("//*[@class='select2-selection__rendered' and @title = 'Quality Assurance']");
    private By istanbulOption = By.xpath("//*[@class='select2-results__option' and contains(text(), 'Istanbul, Turkiye')]");

    @FindBy(css = "[class*='qualityassurance istanbul-turkiye']")
    private List<WebElement> resultList;

    public OpenPositions_QualityAssurancePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }
    public boolean isOpenPositionPageDisplayed(){

        return driver.getCurrentUrl().equals("https://useinsider.com/careers/open-positions/?department=qualityassurance");
    }
    public void clickFilterByLocationsDropdown(){
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(filterByLocationsDropdown));
        dropdown.click();
    }
    public void clickFilterByQualityAssurance() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(filterByQualityAssurance));
        dropdown.click();
    }
    public void clickIstanbulOption(){
        driver.findElement(istanbulOption).click();
    }
    public List<WebElement> getQualityAssuranceJobs() {
        By jobsSelector = By.cssSelector("[class*='qualityassurance istanbul-turkiye']");
        resultList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(jobsSelector));
        return resultList;
    }
    public boolean isJobListNotEmpty() {
        return !getQualityAssuranceJobs().isEmpty();
    }
    public boolean checkPosition() {
        for (WebElement element : resultList) {
            WebElement elementByPosition = element.findElement(By.cssSelector(".position-title "));
            if (!elementByPosition.getText().contains("Software")) // Will be changed to Quality Assurance to fail
            {
                return false;
            }
        }
        return true;
    }
    public boolean checkDepartment() {
        for (WebElement element : resultList) {
            WebElement elementByDepartment = element.findElement(By.cssSelector(".position-department"));
            if (!elementByDepartment.getText().contains("Quality Assurance")) {
                return false;
            }
        }
        return true;
    }
    public boolean checkLocation() {
        for (WebElement element : resultList) {
            WebElement elementByLocation = element.findElement(By.cssSelector(".position-location"));
            if (!elementByLocation.getText().contains("Istanbul, Turkiye")) {
                return false;
            }
        }
        return true;
    }
    public void clickViewRole() {
        Actions action = new Actions(driver);
        action.scrollByAmount(0,400).perform();
        WebElement jobCard= driver.findElement(By.xpath("//*[@class='position-list-item-wrapper bg-light']"));
        action.moveToElement(jobCard).perform();
        WebElement viewRoleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'jobs.lever') and contains(text(), 'View Role')]")));
        viewRoleButton.click();
    }
    public String checkRedirect() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }
}
