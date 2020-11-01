package org.litvinchuk.tests;

import org.aeonbits.owner.ConfigFactory;
import org.litvinchuk.ConfigProperties;
import org.litvinchuk.base.BasePage;
import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.HeaderMenu;
import org.litvinchuk.base.HeaderMenuItem;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.CartPage;
import org.litvinchuk.page_objects.LoginPage;
import org.litvinchuk.page_objects.ProductPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TermsOfServiceCheckboxTest extends BaseTest {

    ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @BeforeClass
    public void beforeTermsOfServiceCheckboxTestClass() {
        goToUrl(ApplicationConstants.PRODUCT_PAGE);
        new HeaderMenu().clickMenuItem(HeaderMenuItem.LOGIN);
        new LoginPage()
                .login(configProperties.validEmail(),
                      configProperties.validPassword(),
                      CartPage.class);
    }

    @AfterClass
    public void afterTermsOfServiceCheckboxTestClass() {
        logoutUser();
    }

    @Test
    public void termsOfServiceCheckboxTest() throws Exception {
//        ProductPage productPage = new ProductPage();
//        CartPage cartPage = new CartPage();
//        productPage.addToCart();

        new ProductPage().addToCart();
        new BasePage()
                .getHeaderMenu()
                .clickMenuItem(HeaderMenuItem.CART);

        new CartPage().clickCheckoutButton();

        Assert.assertTrue(new CartPage()
                .isTermsOfServicePopupVisible("Please accept the terms of service before the next step."));

        new CartPage().closeTermsOfServicePopup();
    }

//        ProductPage popupText = new BasePage()
//                .getCategoryMenu()
//                .selectSubCategory("Notebooks", ProductPage.class)
//                .addToCart();
//
//    }
}
