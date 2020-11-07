package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.HeaderMenu;
import org.litvinchuk.base.HeaderMenuItem;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.CartPage;
import org.litvinchuk.page_objects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductToCartTest extends BaseTest {

    @BeforeClass
    public void beforeAddProductToCartTestClass() {
        goToUrl(ApplicationConstants.PRODUCT_PAGE);
        loginAsRegularUser();
    }

    @AfterClass
    public void afterAddProductToCartTestClass() {
      logoutUser();
    }

    @Test
    public void addToCartTest() {

        new ProductPage().addToCart();
        String productName = new ProductPage().getProductNameText();
        new HeaderMenu().clickMenuItem(HeaderMenuItem.CART);

        Assert.assertEquals(productName, new CartPage().getProductName());
    }
}
