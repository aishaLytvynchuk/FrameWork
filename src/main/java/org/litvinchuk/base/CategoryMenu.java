package org.litvinchuk.base;

import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryMenu {
    static final Logger logger = LoggerFactory.getLogger(CategoryMenu.class);

    @FindBy(css = ".page.category-page")
    private WebElement pageBaseElement;

    @FindBy(css = ".sublist.first-level")
    private WebElement sublistElement;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//li//a")
    private WebElement categoryMenuItem;

    @FindBy(xpath = "//ul[@class='sublist first-level']//li//a")
    private WebElement subCategoryMenuItem;

    @FindBy(className = "page-title")
    private WebElement pageTitle;

    public CategoryMenu() {
        super();
        logger.info("Init " + CategoryMenu.class.getName() + " page");
    }

    public void selectFromMainCategoryMenu(String... categoryMenuItems) {
        pageBaseElement
                .findElement(By.xpath(".//ul[@class='top-menu notmobile']//li//a[text()='" + categoryMenuItems + "]"))
                .click();

    }

    public <T> T selectSubCategory(String subCategoryMenuItem, Class<T> pageToReturn) throws IllegalAccessException, InstantiationException {
        pageBaseElement
                .findElement(By.xpath(".//*[@class='sub-category-item']/h2/a[text()='" + subCategoryMenuItem + "]"))
                .click();
        return pageToReturn.newInstance();

    }


    public void selectFromCategoryMenu(String... menuItems) throws Exception {
        WebDriver driver = WebDriverHolder.getInstance().getDriver();
        switch (menuItems.length) {
            case 0:
                throw new Exception("Unexpected value: " + menuItems.length);
            case 1:
                driver.findElement(By.linkText(menuItems[0])).click();
                break;
            case 2:
                WebElement mainElement = driver.findElement(By.linkText(menuItems[0]));
                new Actions(driver).moveToElement(mainElement).build().perform();
                 WebElement sublistElement = driver.findElement(By.cssSelector(".sublist.first-level"))
                        .findElement(By.linkText(menuItems[1]));
                sublistElement.click();
                break;
        }
    }

    public String getTextFromCategoryMenuItem() {
        logger.info("Get text from menu item");
        return categoryMenuItem.getText();
    }

    public String getTextFromCategorySublistMenuItem() {
        logger.info("Get text from 'Category' sublist menu item");
        return categoryMenuItem.getText();
    }
}


