package org.litvinchuk.tests;

import org.litvinchuk.base.BaseTest;
import org.litvinchuk.constants.ApplicationConstants;
import org.litvinchuk.page_objects.ProductPage;
import org.litvinchuk.webDriwer.WebDriverHolder;
import org.litvinchuk.webDriwer.WebDriverType;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DownloadTest extends BaseTest {

    @BeforeSuite(alwaysRun = true)
    @Override
    public void beforeSuite() throws IOException {
        String browser = System.getProperty("browser", "CHROME_DRIVER_FOR_DOWNLOADS");
        WebDriverHolder.getInstance().initDriver(WebDriverType.valueOf(browser.toUpperCase()));
    }

    @Test
    public void downloadTest() throws IOException {

        goToUrl(ApplicationConstants.DOWNLOAD_FILE);
        File file = new ProductPage().downloadFile("If_You_Wait_1.txt");
        String fileName = file.getName();

        Assert.assertTrue(file.isFile());
        Assert.assertEquals(fileName, "If_You_Wait_1.txt");

    }
}
