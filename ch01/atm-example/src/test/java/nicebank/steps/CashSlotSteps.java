package nicebank.steps;

import cucumber.api.java.en.Then;
import nicebank.support.KnowsTheDomain;
import org.junit.Assert;

public class CashSlotSteps {

    private KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper)
    {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().getContents());
    }
}
