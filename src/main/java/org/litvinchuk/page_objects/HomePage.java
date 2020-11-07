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

}
