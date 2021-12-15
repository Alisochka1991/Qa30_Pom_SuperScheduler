package scheduler;

import config.ConfigurationScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import scedulerscreens.SplashScreen;

public class LaunchAppTest extends ConfigurationScheduler {
    @Test(enabled = false)
    public void launchTest()
    {
        logger.info("Start version 0.0.3");
        String version = new SplashScreen(driver).gerCurrencyVersion();
        Assert.assertEquals(version,"0.0.3");

    }

}
