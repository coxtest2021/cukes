package nicebank;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Steps {

    class Account
    {
        private Money balance = new Money();

        public void deposit(Money amount)
        {
            balance = balance.addMoney(amount);
        }

        public Money getBalance()
        {
            return balance;
        }
    }

    @Given("^I have deposited \\$([\\d]+)\\.([\\d][\\d]) in my account$")
    public void iHaveDeposited$InMyAccount(int dollars, int cents)
    {
        Account myAccount = new Account();
        Money amount = new Money(dollars, cents);

        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect account balance -",
                amount, myAccount.getBalance());
    }


    @When("^I request \\$(\\d+)$")
    public void iRequest$(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
