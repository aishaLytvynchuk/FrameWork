package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.base.CurrencySelectComponent;
import org.litvinchuk.constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CurrencySelectTest extends BaseTest {

//    String currencySymbol


    @BeforeClass
    public void beforeCurrencySelectTestClass() {
        goToUrl(ApplicationConstants.APP_URL);
    }

    @Test(dataProvider = "CurrencySelectProvider")
    public void currencySelectTest(String option, String currencySymbol) {

        new CurrencySelectComponent().selectCurrencyOption(option);

        Assert.assertEquals(option, new CurrencySelectComponent().getSelectedOptionText());

        Assert.assertTrue(new CurrencySelectComponent().isActualPriceContainCurrencySymbol(currencySymbol));

    }

    @DataProvider(name = "CurrencySelectProvider")
    public Object[][] data() {
        return new Object[][]
                {
                        {"Euro", "€"},
                        {"US Dollar", "$"},
                };
    }
}
