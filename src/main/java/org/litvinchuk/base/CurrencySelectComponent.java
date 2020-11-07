package org.litvinchuk.base;

import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CurrencySelectComponent {
    static final Logger logger = LoggerFactory.getLogger(HeaderMenu.class);

    public void selectCurrencyOption(String option) {
        logger.info("Select option from currency");
        new Select(WebDriverHolder.getInstance().getDriver()
                .findElement(By.id("customerCurrency")))
                .selectByVisibleText(option);

    }

    public String getSelectedOptionText() {
        logger.info("Getting text from selected option...");

        WebElement element = WebDriverHolder.getInstance().getDriver()
                .findElement(By.id("customerCurrency"));
        Select select = new Select(element);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for(WebElement selectedOption : selectedOptions) {
            return selectedOption.getText();
        }
        return null;
    }

    public boolean isActualPriceContainCurrencySymbol(String currencySymbol) {
        try {
            logger.info("Check if there is a symbol in the actual price");
            WebElement element = WebDriverHolder.getInstance().getDriver()
                    .findElement(By.xpath("//div[@class='prices']/span[contains(text(),'" + currencySymbol + "')]"));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
