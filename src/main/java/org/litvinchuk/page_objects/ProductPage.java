package org.litvinchuk.page_objects;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ProductPage extends BasePage {
    static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "add-to-wishlist-button-4")
    private WebElement wishlistButton;

    @FindBy(id = "add-to-cart-button-4")
    private WebElement cartButton;

    @FindBy(className = "bar-notification")
    private WebElement barNotification;

    @FindBy(className = "close")
    private WebElement barNotificationCloseButton;

    @FindBy(xpath = "//*[@class='content']")
    private WebElement successNotification;

    @FindBy(className = "download-sample-button")
    private WebElement downloadButton;


    public ProductPage() {
        super();
        logger.info("Init " + ProductPage.class.getName() + " page");
    }

    public File downloadFile(String fileName) {
        logger.info("Downloading file... ");
        downloadButton.click();
        sleep(5000);
        return new File(ApplicationConstants.downloadsFolder, fileName);
    }

    public void addToWishlist() {
        logger.info("Adding to wishlist");
        wishlistButton.click();
        waitForVisibilityOfElement(barNotification);
        barNotificationCloseButton.click();
        sleep(1000);
    }

    public ProductPage addToCart() {
        logger.info("Adding to cart");
        cartButton.click();
        waitForVisibilityOfElement(barNotification);
        barNotificationCloseButton.click();
        sleep(1000);
       return null;
    }

    public String getProductNameText() {
        logger.info("Getting product name from Product page");
        WebElement title = WebDriverHolder.getInstance().getDriver()
                .findElement(By.xpath("//*[@class=\"product-name\"]/h1"));
        return title.getText();
    }

    public String getProductTitleText() {
        logger.info("Get title from product");
        WebElement title = WebDriverHolder.getInstance().getDriver()
                .findElement(By.xpath("//*[@class=\"product-title\"]/a"));
        return title.getText();
    }




//    public String getSearchedProduct() {
//        logger.info("Get searched products");
//
//        List<String> elements = Collections.singletonList(ProductPage.getProductTitleTex());
//
//            for (String elementOfList: elements) {
//                if()
//                return elementOfList;
//            }
//        return null;
//    }

//    public boolean isBarNotificationVisible() {
//        try {
//            logger.info("Checking if notification is visible!");
//            WebDriverHolder.getInstance().getDriver();
//            waitForVisibilityOfElement(barNotification);
//            return barNotification .isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public String getSuccessBarNotificationText() {
//        waitForVisibilityOfElement(successNotification);
//        return WebDriverHolder.getInstance().getDriver()
//                .findElement(By.xpath("//*[@class,'content']")
//                .getText();
//    }

}
