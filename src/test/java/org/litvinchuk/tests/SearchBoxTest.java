package org.litvinchuk.tests;

import org.litvinchuk.base.BasePage;
import org.litvinchuk.base.BaseTest;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchBoxTest extends BaseTest {

    String searchParameter = "HTC";

    @BeforeClass
    public void beforeSearchBoxTestClass() {
        goToUrl(ApplicationConstants.APP_URL);
    }

    @Test
    public void searchBoxTest() throws Exception {

        new BasePage().search(searchParameter);

        Assert.assertTrue(new ProductPage().getProductTitleText().contains(searchParameter));
    }
}
