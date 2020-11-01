package org.litvinchuk.page_objects;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends BasePage {
    static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "Email")
    private WebElement userEmailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(css = ".button-1.login-button")
    private WebElement loginButton;

    @FindBy(className = "ico-login")
    private WebElement loginMenuItem;

    @FindBy(id = "Email-error")
    private WebElement errorEmailMessage;

    @FindBy(className = "message-error")
    private WebElement errorMessage;


    public LoginPage() {
        super();
        logger.info("Init " + LoginPage.class.getName() + " page");
    }

    public <T extends BasePage> T login(String userEmail, String userPassword, Class<T> pageToReturn) {
        logger.info("Login in with parameters:\nEmail: "
                + userEmail + "\nPassword: " + userPassword);
        userEmailInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        passwordInput.submit();
        try {
            return pageToReturn.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isErrorMessageVisible(String text) {
        try {
            logger.info("Check is errorMessage visible!");
            WebElement element = WebDriverHolder.getInstance().getDriver()
                    .findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

//    public String getMessageErrorText() {
//        logger.info("Get text from error message");
//        WebDriverHolder.getInstance().getDriver()
//                .findElement(By.xpath("//*[contains(@class,'message-error validation-summary-errors')]"));
//        return messageError.getText();
//    }
//
//    public String getEmailErrorMessageText() {
//        logger.info("Get text from error message");
//        WebDriverHolder.getInstance().getDriver().findElement(By.id("Email-error"));
//        return emailErrorMessage.getText();
//    }
}
