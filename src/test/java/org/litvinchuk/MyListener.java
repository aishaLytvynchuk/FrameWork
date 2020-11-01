package org.litvinchuk;

import org.apache.commons.io.FileUtils;
import org.litvinchuk.webDriwer.WebDriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import java.io.File;
import java.io.IOException;

public class MyListener implements IResultListener {
    static final Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onConfigurationSuccess(ITestResult itr) {

    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {

    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {

    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getName() + " started!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + " finished SUCCESSFULLY!");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getName() + " FAILED!!!!");
        takeScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    private File takeScreenshot(String testName) {
        File screenShot = ((TakesScreenshot) WebDriverHolder.getInstance().getDriver())
                .getScreenshotAs(OutputType.FILE);
        File distFile = new File(new File("screenshots"), testName + ".png");
        try {
            FileUtils.copyFile(screenShot, distFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return distFile;
    }
}
