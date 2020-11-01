package org.litvinchuk.tests;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.HeaderMenuItem;
import org.litvinchuk.constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HeaderMenuNavigationTest extends BaseTest {

    @BeforeClass
    public void beforeHeaderMenuNavigationTestClass() {
        goToUrl(ApplicationConstants.APP_URL);
    }

    @Test(dataProvider = "HeaderMenuDataProvider")
    public void HeaderMenuTest(HeaderMenuItem menuItem, String title) {
       new BasePage()
               .getHeaderMenu()
               .clickMenuItem(menuItem);

        Assert.assertEquals(new BasePage().getPageTitle(), title);
    }

    @DataProvider(name = "HeaderMenuDataProvider")
    public Object[][] data() {
        return new Object[][]
            {
                {HeaderMenuItem.REGISTER, "Register"},
                {HeaderMenuItem.LOGIN, "Welcome, Please Sign In!"},
                {HeaderMenuItem.WISHLIST, "Wishlist"},
                {HeaderMenuItem.CART, "Shopping cart"},

            };
    }
}
