package nicebank.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import nicebank.support.KnowsTheDomain;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverHooks {

   private KnowsTheDomain helper;

    public WebDriverHooks(KnowsTheDomain helper)
    {
        this.helper = helper;
    }

    @After
    public void finish(Scenario scenario)
    {
        try {
            byte[] screenshot =
                    helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            System.out.println("******** screenshot taken!");
        } catch (WebDriverException somePlatformsDontSupportScreenshots)
        {
            System.err.println("******** screenshot not taken!");
        } finally {
            helper.getWebDriver().close();
        }
    }
}
