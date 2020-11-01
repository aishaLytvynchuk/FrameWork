package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.HeaderMenu;
import org.litvinchuk.constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeClass
    public void beforeClassLogoutTest() {
        goToUrl(ApplicationConstants.LOGIN_PAGE);
        loginAsRegularUser();
    }

    @Test
    public void logoutTest() {

        new HeaderMenu().logout();

        Assert.assertTrue(new HeaderMenu().isLogoutSuccessful());
    }

}
