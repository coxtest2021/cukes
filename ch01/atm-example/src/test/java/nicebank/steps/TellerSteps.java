package nicebank.steps;

import cucumber.api.java.en.When;
import nicebank.support.KnowsTheDomain;

public class TellerSteps {

    private KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper)
    {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int dollars) throws Throwable {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
    }
}
