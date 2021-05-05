package nicebank.steps;

import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import nicebank.Money;
import nicebank.support.KnowsTheDomain;
import nicebank.transforms.MoneyConverter;
import org.junit.Assert;

public class AccountSteps {

    private KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper)
    {
        this.helper = helper;
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount)
            throws Throwable
    {
        helper.getMyAccount().credit(amount);

        int pollInterval = 100;
        int timeoutMillisecs = 5000;

        while(!helper.getMyAccount().getBalance().equals(amount) && timeoutMillisecs > 0)
        {
            timeoutMillisecs -= pollInterval;

            Thread.sleep(pollInterval);
        }

        Assert.assertEquals("Incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }

    @And("^The balance in my account must be (\\$\\d+\\.\\d+)$")
    public void theBalanceIs(@Transform(MoneyConverter.class) Money amount)
            throws Throwable
    {

        int pollInterval = 100;
        int timeoutMillisecs = 5000;

        while(!helper.getMyAccount().getBalance().equals(amount) && timeoutMillisecs > 0)
        {
            timeoutMillisecs -= pollInterval;

            Thread.sleep(pollInterval);
        }

        Assert.assertEquals("Incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }

}
