package org.litvinchuk.webDriwer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.litvinchuk.constants.ApplicationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    public static WebDriver getDriver(WebDriverType webDriverType) {
        WebDriver driver = null;
        switch (webDriverType){
            case CHROME_DRIVER:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX_DRIVER:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME_DRIVER_FOR_DOWNLOADS:
                try {
                    FileUtils.cleanDirectory(ApplicationConstants.downloadsFolder);
                } catch (IOException e) {

                    e.printStackTrace();
                }
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefsMap = new HashMap<String, Object>();
                prefsMap.put("profile.default_content_settings.popups", 0);
                prefsMap.put("download.default_directory", ApplicationConstants.downloadsFolder.getAbsolutePath());

                ChromeOptions option = new ChromeOptions();
                option.setExperimentalOption("prefs", prefsMap);
                option.addArguments("--test-type");
                option.addArguments("--disable-extensions");

                driver = new ChromeDriver(option);
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }


}
