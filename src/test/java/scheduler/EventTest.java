package scheduler;

import config.ConfigurationScheduler;
import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scedulerscreens.HomeScreen;
import scedulerscreens.LoginScreen;
import scedulerscreens.SplashScreen;

public class EventTest extends ConfigurationScheduler {
    @BeforeMethod
    public void precondition()
    {
        new LoginScreen(driver)
                .loginComplex(Auth.builder()
                        .email("alisiaagranov1@gmail.com")
                        .password("212229Alisa")
                        .build())
                        .skipWizard()
                        .isFabAddPresent();
    }
    @Test
    public void createNewEventTest()
    {
        boolean isFabAddPresent =    new HomeScreen(driver)
            .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Event")
                        .type("new")
                        .breaks(2)
                        .wage(50)
                        .build())
                .isFabAddPresent();
        Assert.assertTrue(isFabAddPresent);
    }

    @Test(enabled = false)
    public void createEventComplex()
    {
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginComplex(Auth.builder()
                        .email("alisiaagranov@gmail.com")
                        .password("212229Alisa")
                        .build())
                .skipWizard()
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Event")
                        .type("New")
                        .breaks(2)
                        .wage(50)
                        .build())
                .isFabAddPresent();
    }

}
