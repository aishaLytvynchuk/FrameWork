package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SuccessfulLoginTest extends BaseTest {

    @BeforeClass
    public void beforeClassSuccessfulLoginTest() {
        goToUrl(ApplicationConstants.LOGIN_PAGE);
    }

    @AfterClass
    public void afterClassSuccessfulLoginTest() {
        logoutUser();
    }

    @Test
    public void successfulLoginTest() {

        Assert.assertTrue(new LoginPage()
                .login(configProperties.validEmail(),
                        configProperties.validPassword(),
                        LoginPage.class)
                .getHeaderMenu()
                .isLoginSuccessful());
    }
}
