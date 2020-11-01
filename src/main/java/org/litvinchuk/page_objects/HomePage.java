package org.litvinchuk.page_objects;

import org.litvinchuk.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @FindBy(id = "nivo-slider")
    private WebElement imageSlider;

    @FindBy(className = "topic-block-title")
    private WebElement topicTitle;

//    @FindBy(xpath = ".//div[@class='prices']/span")
//    private WebElement actualPrice;


    public boolean isImageSliderVisible() {
        try {
            logger.info("Check is imageSlider visible!");
            return imageSlider.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTopicTitleText() {
        logger.info("Get text from title");
        return topicTitle.getText();
    }



//    public String getSymbolFromActualPrice() {
//        logger.info("Get symbol from actual price");
//        WebElement element = WebDriverHolder.getInstance().getDriver()
//                .findElement(By.xpath(".//div[@class='prices']/span"));
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("US Dollar","$");
//        map.put("Euro","€");
//
//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            return pair.getKey();
//        }
//        return element.getText();
//    }

//    public String getSymbolFromActualPrice() {
//        Set<Currency> currencies = Currency.getAvailableCurrencies();
//        String symbol = actualPrice.toString();
//        return currencies.stream().findFirst().map(Currency::getSymbol).orElse(null);
//    }

}
