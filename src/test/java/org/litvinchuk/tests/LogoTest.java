package org.litvinchuk.tests;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.HeaderMenuItem;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoTest extends BaseTest {
    @BeforeClass
    public void beforeLogoTestClass() {
        goToUrl(ApplicationConstants.APP_URL);
    }

    @Test
    public void logoTest() throws Exception {

      new BasePage()
                .getHeaderMenu()
                .clickMenuItem(HeaderMenuItem.WISHLIST);

      BasePage.clickLogo();

      Assert.assertTrue(new HomePage().getTopicTitleText().contains("Welcome to our store"));
      Assert.assertTrue(new HomePage().isImageSliderVisible());
    }
}
