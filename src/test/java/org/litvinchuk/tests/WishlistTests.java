package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.HeaderMenu;
import org.litvinchuk.base.HeaderMenuItem;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.ProductPage;
import org.litvinchuk.page_objects.WishlistPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WishlistTests extends BaseTest {

    @BeforeClass
    public void beforeWishlistTestClass() {
        goToUrl(ApplicationConstants.PRODUCT_PAGE);
    }

    @Test
    public void addToWishlistTest() {

        new ProductPage().addToWishlist();

        Assert.assertEquals(new ProductPage().getProductNameText(), new WishlistPage().getProductName());
    }

    @Test
    public void removeFromWishlistTest() {

        new ProductPage().addToWishlist();
        new HeaderMenu().clickMenuItem(HeaderMenuItem.WISHLIST);
        new WishlistPage().removeFromWishlist();

        Assert.assertTrue(new WishlistPage().isNoDataNotificationVisible());
//        Assert.assertEquals(new WishlistPage().getNoDataText(), "The wishlist is empty!");
        Assert.assertTrue(new WishlistPage().getNoDataText().contains("The wishlist is empty!"));
    }
}
