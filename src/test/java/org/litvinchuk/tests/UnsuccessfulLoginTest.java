package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnsuccessfulLoginTest extends BaseTest {

    @BeforeClass
    public void beforeClassUnsuccessfulLoginTest() {
        goToUrl(ApplicationConstants.LOGIN_PAGE);
    }


    @Test(dataProvider = "UserCredentialsDataProvider")
    public void unsuccessfulLoginTest(String email, String password, String errorMessage) {

        new LoginPage()
                .login(email, password, LoginPage.class);

        Assert.assertTrue(new LoginPage().isErrorMessageVisible(errorMessage));


        //        Assert.assertTrue(loginPage.getEmailErrorMessageText()
//                .contains(configProperties.emailErrorMessage()));
//        Assert.assertTrue(loginPage.getMessageErrorText()
//                .contains(configProperties.credentialsMessageError()));
    }


    @DataProvider(name = "UserCredentialsDataProvider")
    public Object[][] data() {
        return new Object[][]
                {
                        {
                                configProperties.invalidEmail1(),
                                configProperties.invalidPassword1(),
                                configProperties.emailErrorMessage()
                        },
                        {
                                configProperties.invalidEmail2(),
                                configProperties.invalidPassword2(),
                                configProperties.credentialsMessageError()
                        },

                };
    }
}
