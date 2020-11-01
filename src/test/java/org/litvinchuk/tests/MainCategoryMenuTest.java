package org.litvinchuk.tests;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.CategoryMenu;
import org.litvinchuk.constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainCategoryMenuTest extends BaseTest {

    @BeforeClass
    public void beforeMainCategoryMenuTestClass() {
        goToUrl(ApplicationConstants.APP_URL);
    }

    @Test(dataProvider = "MainCategoryDataProvider")
    public static void mainCategoryMenu(String... categoryMenuItems) {

        new CategoryMenu().selectFromMainCategoryMenu(categoryMenuItems);

        Assert.assertEquals(new BasePage().getPageTitle(), new CategoryMenu().getTextFromCategoryMenuItem());
    }

    @DataProvider(name = "MainCategoryDataProvider")
    public Object[][] data() {
        return new Object[][]
                {
                        {"Computers"},
                        {"Electronics"},
                        {"Apparel"},
                        {"Digital downloads"},
                        {"Books"},
                        {"Jewelry"},
                        {"Gift Cards"},
                };
    }
}
