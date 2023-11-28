import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BT_Keywords {
	private WebDriver driver;

    public void launchApplication(String url) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeCookiePopup() {
        try {
            WebElement cookiePopup = driver.findElement(By.id("cookie-popup"));
            if (cookiePopup.isDisplayed()) {
                cookiePopup.findElement(By.id("cookie-accept")).click();
            }
        } catch (NoSuchElementException ignored) {
            // Cookie popup not found, continue
        }
    }

    public void hoverToMobileMenu() {
        WebElement mobileMenu = driver.findElement(By.xpath("//span[contains(text(),'Mobile')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mobileMenu).perform();
    }

    public void selectMobilePhones() {
        // Code to select Mobile phones from the menu
        WebElement mobilePhonesOption = driver.findElement(By.xpath("//a[contains(text(),'Mobile phones')]"));
        mobilePhonesOption.click();
    }

    public boolean verifyBannerCount(String bannerText, int minCount) {
        List<WebElement> banners = driver.findElements(By.xpath("//div[contains(text(), '" + bannerText + "')]"));
        return banners.size() >= minCount;
    }

    public void scrollAndClickSimDeals() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to find View SIM only deals
        WebElement simDealsLink = driver.findElement(By.linkText("View SIM only deals"));
        js.executeScript("arguments[0].scrollIntoView();", simDealsLink);

        // Click View SIM only deals
        simDealsLink.click();
    }

    public boolean validateTitle() {
        return driver.getTitle().contains("SIM Only Deals");
    }

    public boolean validatePromotionDetails(String promotion, String plan, double oldPrice, double newPrice) {
        // Example validation for promotion details
        WebElement promotionElement = driver.findElement(By.xpath("//div[contains(text(), '" + promotion + "')]"));
        WebElement planElement = driver.findElement(By.xpath("//div[contains(text(), '" + plan + "')]"));
        WebElement priceElement = driver.findElement(By.xpath("//div[contains(text(), 'was £" + oldPrice + " £" + newPrice + " per month')]"));

        return promotionElement.isDisplayed() && planElement.isDisplayed() && priceElement.isDisplayed();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

