package org.litvinchuk.page_objects;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutPage extends BasePage {
    static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

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
    private WebElement agreeCheckBox;

    @FindBy(id = "ShipToSameAddress")
    private WebElement shipToSameAddressCheckBox;

    @FindBy(className = "new-address-next-step-button")
    private WebElement newAddressNextStepButton;

    @FindBy(className = "shipping-method-next-step-button")
    private WebElement shippingMethodNextStepButton;

    @FindBy(id = "paymentmethod_1")
    private WebElement checkMoneyOrder;

    @FindBy(className = "payment-method-next-step-button")
    private WebElement paymentMethodNextStepButton;

    @FindBy(className = "payment-info-next-step-button")
    private WebElement paymentInfoNextStepButton;

    @FindBy(className = "confirm-order-next-step-button")
    private WebElement confirmOrderButton;

    public CheckoutPage() {
        super();
        logger.info("Init " + CheckoutPage.class.getName() + " page");
    }

    public void inputData(String fieldId, String data) {
        logger.info("Focused on " + fieldId + "input " + data);
        WebElement field = WebDriverHolder.getInstance().getDriver().findElement(By.id(fieldId));
        field.clear();
        field.sendKeys(data);
    }


    public void selectDataOption(String fieldId, String data) {
        logger.info("Focused on " + fieldId + "input " + data);
        WebElement dropDown = WebDriverHolder.getInstance().getDriver().findElement(By.id(fieldId));

        new Select(dropDown).selectByVisibleText(data);
    }

    public void clickOnNewAddressContinueButton() {
        newAddressNextStepButton.click();
    }

    public void clickOnShipToSameAddressCheckBox() {
        shippingMethodNextStepButton.click();
    }

    public void clickOnShippingMethodContinueButton() {
        shippingMethodNextStepButton.click();
    }
    public void clickOnCheckMoneyOrder() {
        checkMoneyOrder.click();
    }

    public void clickOnPaymentMethodContinueButton() {
        paymentMethodNextStepButton.click();
    }


    public void clickOnPaymentInfoContinueButton() {
        paymentInfoNextStepButton.click();
    }

    public void clickOnConfirmOrderButton() {
        confirmOrderButton.click();
    }
}
