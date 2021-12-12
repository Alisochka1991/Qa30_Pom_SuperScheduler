package scheduler;

import config.ConfigurationScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import scedulerscreens.SplashScreen;

public class LaunchAppTest extends ConfigurationScheduler {
    @Test
    public void launchTest()
    {
        String version = new SplashScreen(driver).gerCurrencyVersion();
        Assert.assertEquals(version,"0.0.3");

    }

}
