package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.HeaderMenu;
import org.litvinchuk.base.HeaderMenuItem;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.CheckoutPage;
import org.litvinchuk.page_objects.LoginPage;
import org.litvinchuk.page_objects.ProductPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class InputBillingAddressDataTest extends BaseTest {

    @BeforeClass
    public void beforeInputBillingAddressDataTestClass() {
        clearAllCookies();
        goToUrl(ApplicationConstants.CHECKOUT_PAGE);
        new HeaderMenu().clickMenuItem(HeaderMenuItem.LOGIN);
        new LoginPage()
                .login(configProperties.validEmail(),
                        configProperties.validPassword(),
                        ProductPage.class);
    }

    @AfterClass
    public void afterInputBillingAddressDataTestClass() {
        clearAllCookies();
    }


    @Test
    public void InputBillingAddressDataTest() {
        CheckoutPage checkoutPage = new CheckoutPage();
        Map<String, String> billingNewAddressInputs = new HashMap<String, String>();
        billingNewAddressInputs.put("BillingNewAddress_FirstName", configProperties.firstName());
        billingNewAddressInputs.put("BillingNewAddress_LastName", configProperties.lastName());
        billingNewAddressInputs.put("BillingNewAddress_Email", configProperties.validEmail());
        billingNewAddressInputs.put("BillingNewAddress_Company", configProperties.company());
        billingNewAddressInputs.put("BillingNewAddress_City", configProperties.city());
        billingNewAddressInputs.put("BillingNewAddress_Address1", configProperties.address1());
        billingNewAddressInputs.put("BillingNewAddress_Address2", configProperties.address2());
        billingNewAddressInputs.put("BillingNewAddress_ZipPostalCode", configProperties.postalCode());
        billingNewAddressInputs.put("BillingNewAddress_PhoneNumber", configProperties.phoneNumber());
        billingNewAddressInputs.put("BillingNewAddress_FaxNumber", configProperties.faxNumber());
        for (Map.Entry<String, String> pair : billingNewAddressInputs.entrySet()) {
            checkoutPage. inputData(pair.getKey(), pair.getValue());
        }


        checkoutPage.selectDataOption("BillingNewAddress_CountryId", configProperties.country());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.selectDataOption("BillingNewAddress_StateProvinceId", configProperties.state());

        checkoutPage.clickOnNewAddressContinueButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
