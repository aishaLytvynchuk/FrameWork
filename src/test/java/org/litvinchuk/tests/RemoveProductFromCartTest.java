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

public class RemoveProductFromCartTest extends BaseTest {

    @BeforeClass
    public void beforeRemoveProductFromCartTestClass() {
        goToUrl(ApplicationConstants.PRODUCT_PAGE);
        loginAsRegularUser();
    }

    @AfterClass
    public void afterAddProductToCartTestClass() {
        logoutUser();
    }

    @Test
    public void removeProductFromCartTest() {
//        ProductPage productPage = new ProductPage();
//        productPage.addToCart();
//        new BasePage().getHeaderMenu().clickMenuItem(HeaderMenuItem.CART);
//        CartPage cartPage = new CartPage();
//        cartPage.removeProduct();
//        Assert.assertTrue(cartPage.isCartEmpty());

        new ProductPage().addToCart();

        new HeaderMenu().clickMenuItem(HeaderMenuItem.CART);

        new CartPage().removeProduct();

        Assert.assertTrue(new CartPage().isCartEmpty());
        Assert.assertTrue(new CartPage().getNoDataText().contains("Your Shopping Cart is empty!"));
    }
}
