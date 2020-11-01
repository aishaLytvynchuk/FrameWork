package org.litvinchuk.base;

import org.aeonbits.owner.ConfigFactory;
import org.litvinchuk.ConfigProperties;
import org.litvinchuk.MyListener;
import org.litvinchuk.page_objects.LoginPage;
import org.litvinchuk.webDriwer.WebDriverHolder;
import org.litvinchuk.webDriwer.WebDriverType;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners({MyListener.class})
public class BaseTest {

    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IOException {
        WebDriverHolder.getInstance().initDriver(WebDriverType.CHROME_DRIVER);
    }

//    @AfterSuite(alwaysRun = true)
//    public void afterSuite() {
//        if(WebDriverHolder.getInstance().getDriver() != null) {
//            WebDriverHolder.getInstance().getDriver().quit();
//        }
//    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void loginAsRegularUser() {
        if(new HeaderMenu().isLogoutSuccessful()) {
            new HeaderMenu().clickMenuItem(HeaderMenuItem.LOGIN);
            new LoginPage()
                    .login(configProperties.validEmail(),
                           configProperties.validPassword(),
                            LoginPage.class);
        }
    }

    public void logoutUser() {
        if(new HeaderMenu().isLoginSuccessful()) {
            new HeaderMenu().logout();
        }
    }

    public void clearAllCookies() {
       WebDriverHolder.getInstance().getDriver().manage().deleteAllCookies();
       WebDriverHolder.getInstance().getDriver().navigate().refresh();
    }

}
