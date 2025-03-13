package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {
    public WebDriver driver;
    private By teamBlock = By.cssSelector(".career-load-more");
    private By locationBLock = By.xpath("//div[@id='location-slider' and @class='glide mb-5 non-footer glide--ltr glide--slider glide--swipeable']");
    private  By lifeAtInsider = By.xpath("//div[contains(@class, 'elementor-container') and contains(@class, 'elementor-column-gap-default')]//*[contains(text(), 'Life at Insider')]/ancestor::*[5]\n");


    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCareerPageDisplayed(){
        return driver.getTitle().equals("Ready to disrupt? | Insider Careers");
    }
    public boolean isTeamBlockDisplayed(){
        return driver.findElement(teamBlock).isDisplayed();
    }
    public boolean isLocationBlockDisplayed(){
        return driver.findElement(locationBLock).isDisplayed();
    }
    public boolean isLifeAtInsiderDisplayed(){
        return driver.findElement(lifeAtInsider).isDisplayed();
    }

}
