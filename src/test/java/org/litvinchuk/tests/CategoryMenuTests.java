package org.litvinchuk.tests;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.base.BaseTest;
import org.litvinchuk.constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CategoryMenuTests extends BaseTest {

    @BeforeClass
    public void beforeCategoryMenuTestsClass() {
        goToUrl(ApplicationConstants.APP_URL);
    }

    @Test(dataProvider = "ComponentMenuDataProvider")
    public void CategoryMenu(String... menuItems) throws Exception {
        new BasePage()
                .getCategoryMenu()
                .selectFromCategoryMenu(menuItems);

        Assert.assertEquals(new BasePage().getPageTitle(), menuItems);

//        Assert.assertEquals(new CategoryMenu().getTextFromCategoryMenuItem(), new BasePage().getPageTitle());
//        Assert.assertEquals(new CategoryMenu().getTextFromCategorySublistMenuItem(), new BasePage().getPageTitle());

    }

    @DataProvider(name = "ComponentMenuDataProvider")
    public Object[][] data() {
        return new Object[][]
                {
                        {"Computers"},
                        {"Computers", "Desktops"},
                        {"Computers", "Notebooks"},
                        {"Computers", "Software"},
//                        {"Electronics"},
//                        {"Electronics", "Camera & photo "},
//                        {"Electronics", "Cell phones "},
//                        {"Electronics", "Others "},
//                        {"Apparel"},
//                        {"Digital downloads"},
//                        {"Books"},
//                        {"Jewelry"},
//                        {"Gift Cards"},
                };
    }

}
