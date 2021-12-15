package scheduler;

import config.ConfigurationScheduler;
import config.DataProviderMy;
import config.ListenerTestNg;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import scedulerscreens.LoginScreen;
import scedulerscreens.SplashScreen;

//@Listeners(ListenerTestNg.class)

public class LoginTest extends ConfigurationScheduler {
    @Test
    public void loginSuccessTest()
    {
        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("alisiaagranov@gmail.com")
                .fillPassword("212229Alisa")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
        Assert.assertTrue(isFabPresent);
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderMy.class)
    public void loginStatLoginScreen(Auth auth)
    {
       boolean isFabPresent =  new LoginScreen(driver)
              //  .fillEmail("yoyo2@gmail.com")
              //  .fillPassword("212229Alisa")
               .fillEmail(auth.getEmail())
               .fillPassword(auth.getPassword())
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();
       Assert.assertTrue(isFabPresent);
    }

    @Test(dataProvider = "loginDataCSV", dataProviderClass = DataProviderMy.class)
    public void loginStatLoginScreenCSV(Auth auth)
    {
        boolean isBtn =  new LoginScreen(driver)
                .loginComplex(auth)
                .skipWizard()
                .isFabAddPresentAssert()
                .openMenu()
                .logOut()
                .isLoginButtonPresent();

        Assert.assertTrue(isBtn);
    }

    @Test
    public void loginAuthTest()
    {
       boolean isFabPresent = new LoginScreen(driver)
               .loginComplex(Auth.builder().email("uuuuuu1@gmail.com")
                       .password("212229Alisa")
                       .build())
                       .skipWizard()
                       .isFabAddPresent();
       Assert.assertTrue(isFabPresent);


    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderMy.class)
    public void loginAuthTestDP(Auth auth)
    {
     boolean isBtn =  new LoginScreen(driver)
                .loginComplex(auth)
                .skipWizard()
               .isFabAddPresentAssert()
               .openMenu()
               .logOut()
               .isLoginButtonPresent();

Assert.assertTrue(isBtn);

    }

    @Test
    public void loginComplexCheckErrorMessage()
    {
        boolean isLoginButtonPresent = new LoginScreen(driver).loginComplexNegative(Auth.builder()
                        .email("alisiaagranov@gmail.com")
                        .password("212229Sdoas")
                        .build())
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage()
                .isLoginButtonPresent();
        Assert.assertTrue(isLoginButtonPresent);
    }

}
