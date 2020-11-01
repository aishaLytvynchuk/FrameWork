package org.litvinchuk.base;

import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HeaderMenu {

    static final Logger logger = LoggerFactory.getLogger(HeaderMenu.class);

    @FindBy(className = "ico-account")
    private WebElement accountMenuItem;

    @FindBy(className = "ico-register")
    private WebElement register;

    @FindBy(className = "ico-login")
    private WebElement loginMenuItem;

    @FindBy(className = "ico-logout")
    private WebElement logoutMenuItem;

    @FindBy(className = "ico-wishlist")
    private WebElement wishlistMenuItem;

    @FindBy(className = "ico-cart")
    private WebElement cartMenuItem;

    @FindBy(className = "wishlist-qty")
    private WebElement wishlistQty;

    public HeaderMenu() {
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
        logger.info("Init " + HeaderMenu.class.getName() + " page");
    }

    private WebElement getMenuItem(HeaderMenuItem menuItem) {
        return  WebDriverHolder.getInstance().getDriver()
                .findElement(By.className("ico-" + menuItem.name().toLowerCase()));
    }

    public void clickMenuItem(HeaderMenuItem menuItem) {
        logger.info("Click on " + "'" + menuItem + "'" + " menu item");
        getMenuItem(menuItem).click();
    }


    //    public LoginPage selectLoginMenuItem() {
//        loginMenuItem.click();
//        return new LoginPage();
//    }
//
//    public BasePage selectLogoutMenuItem() {
//        logoutMenuItem.click();
//        return new BasePage();
//    }

    public boolean isLoginSuccessful() {
        try {
            logger.info("Checking if logoutMenuItem is visible!");
            return logoutMenuItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        logger.info("Logging out...");
        logoutMenuItem.click();
    }

    public boolean isLogoutSuccessful() {
        try {
            logger.info("Checking if loginMenuItem is visible!");
            return loginMenuItem.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
