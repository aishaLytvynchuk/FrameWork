package org.litvinchuk.webDriwer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHolder {
    private WebDriver driver;

    private  static WebDriverHolder instance = null;

    private WebDriverHolder() {
    }

    public WebDriver getDriver() {
        return driver;
    }


    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    public WebDriverWait getWaiter() {
        return new WebDriverWait(driver, 30);
    }

    public static WebDriverHolder getInstance() {
        if (instance == null){
            instance = new WebDriverHolder();
        }
        return instance;
    }

    public void initDriver(WebDriverType webDriverType) {
        driver = WebDriverFactory.getDriver(webDriverType);
        driver.manage().window().maximize();
    }
}
