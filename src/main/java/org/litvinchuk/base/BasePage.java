package org.litvinchuk.base;

import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    static final Logger logger = LoggerFactory.getLogger(HeaderMenu.class);

    private HeaderMenu headerMenu;
    private CategoryMenu categoryMenu;
    private CurrencySelectComponent currencySelectComponent;
//    private SearchComponent searchComponent;
//    private LogoComponent logoComponent;


    public BasePage() {
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu = new HeaderMenu();
    }

    public CategoryMenu getCategoryMenu() {
        return categoryMenu = new CategoryMenu();
    }

    public CurrencySelectComponent getCurrencySelectComponent() {
        return currencySelectComponent = new CurrencySelectComponent();
    }

    public void search(String searchParameter) {
        logger.info("Input search parameter and searching...");
        WebElement searchInput = WebDriverHolder.getInstance().getDriver()
                .findElement(By.className("search-box-text"));
        WebElement searchButton= WebDriverHolder.getInstance().getDriver()
                .findElement(By.className("search-box-button"));
        searchInput.sendKeys(searchParameter);
        searchButton.submit();
    }

//    public LogoComponent getLogoComponent() {
//        return logoComponent;
//    }




    public static void clickLogo() {
        logger.info("Click on logo component");
        WebDriverHolder.getInstance().getDriver()
                .findElement(By.className("header-logo"))
                .click();
    }




    public String getPageTitle() {
        logger.info("Getting text from page's title");
        return WebDriverHolder.getInstance().getDriver()
                .findElement(By.className("page-title"))
                .getText();
    }

    public static void sleep(long msecs) {
        logger.info("Waitting....");
        try {
            Thread.sleep(msecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForVisibilityOfElement(WebElement element) {
        logger.info("Wait for element to be visible");
        WebDriverHolder.getInstance().getWaiter()
                .until(ExpectedConditions.visibilityOf(element));
    }

    public BasePage waitForPageToLoad() {
        return this;
    }
}
