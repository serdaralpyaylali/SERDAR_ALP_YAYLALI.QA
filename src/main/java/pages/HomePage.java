package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    public WebDriver driver;
    private By company = By.xpath("//*[@id='navbarDropdownMenuLink' and contains(text(), 'Company')]");
    private By careers = By.xpath("//*[@class='dropdown-sub' and contains(text(), 'Careers')]");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isHomepageDisplayed(){
        return driver.getTitle().equals("#1 Leader in Individualized, Cross-Channel CX — Insider");
    }
    public void goToHomePage(WebDriver driver){
        driver.get("https://useinsider.com/");
    }
    public void goToCareersPage(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(company)).click().click(driver.findElement(careers)).build().perform();
    }
}
