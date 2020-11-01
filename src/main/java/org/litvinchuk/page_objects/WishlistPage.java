package org.litvinchuk.page_objects;

import org.litvinchuk.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WishlistPage extends BasePage {
    static final Logger logger = LoggerFactory.getLogger(WishlistPage.class);

    @FindBy(name = "removefromcart")
    private WebElement removeCheckbox;

    @FindBy(name = "updatecart")
    private WebElement updateCartButton;

    @FindBy(className = "no-data")
    private WebElement noData;

    @FindBy(className = "product-name")
    private WebElement productName;

    @FindBy(className = "bar-notification")
    private WebElement barNotification;

    @FindBy(className = "close")
    private WebElement barNotificationCloseButton;

    public WishlistPage() {
        super();
        logger.info("Init " + WishlistPage.class.getName() + " page");
    }

    public String getProductName() {
        logger.info("Getting product name from Wishlist");
       return productName.getText();
    }

    public WishlistPage removeFromWishlist() {
        logger.info("Removing product from Wishlist");
        removeCheckbox.click();
        updateCartButton.click();
        return new WishlistPage();
    }

    public String getNoDataText() {
        logger.info("Getting text from notification on Wishlist page");
        return noData.getText();
    }

    public boolean isNoDataNotificationVisible() {
        try {
            logger.info("Checking if notification is visible!");
            return noData.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWishlistEmpty() {
        logger.info("Checking that Wishlist is empty");
        return noData.isDisplayed();
    }
}
