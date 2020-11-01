package org.litvinchuk.page_objects;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends BasePage {
    static final Logger logger = LoggerFactory.getLogger(CartPage.class);

    @FindBy(name = "removefromcart")
    private WebElement removeCheckbox;

    @FindBy(className = "update-cart-button")
    private WebElement updateCartButton;

    @FindBy(className = "no-data")
    private WebElement noData;

    @FindBy(className = "cart-qty")
    private WebElement wishlistQty;

    @FindBy(className = "product-name")
    private WebElement productName;

    @FindBy(className = "checkout-button")
    private WebElement checkoutButton;

    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckbox;


    public CartPage() {
        super();
        logger.info("Init " + CartPage.class.getName() + " page");
    }

    public String getProductName() {
        logger.info("Getting product name from Cart page");
        return productName.getText();
    }

    public void removeProduct() {
        logger.info("Removing product from cart");
        removeCheckbox.click();
        updateCartButton.click();
        sleep(2000);
    }

    public boolean isCartEmpty() {
        logger.info("Checking that Cart is empty");
        return noData.isDisplayed();
    }

    public String getNoDataText() {
        logger.info("Getting text from notification on Cart page");
        return noData.getText();
    }

    public void clickAgreeCheckBox() {
        logger.info("Putting the mark into the checkbox to agree with terms of service");
        termsOfServiceCheckbox.click();
    }

    public void clickCheckoutButton() {
        logger.info("Click 'Checkout' button on 'Cart' page");
        checkoutButton.click();
    }

    public void closeTermsOfServicePopup() {
        logger.info("Close 'Terms of service' popup");
        new Actions(WebDriverHolder.getInstance().getDriver())
                .moveToElement(WebDriverHolder.getInstance().getDriver()
                        .findElement(By.cssSelector(".ui-button[title=Close]")))
                .click()
                .build()
                .perform();
    }


    public boolean isTermsOfServicePopupVisible(String text) {
        try {
            logger.info("Finding Terms of service popup");
            WebElement element = WebDriverHolder.getInstance().getDriver()
                    .findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
