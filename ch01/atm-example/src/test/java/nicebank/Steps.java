package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nicebank.transforms.MoneyConverter;
import org.junit.Assert;
import org.junit.Test;

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

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount)
            throws Throwable
    {
        Account myAccount = new Account();
        myAccount.deposit(amount);

        Assert.assertEquals("Incorrect account balance -",
                amount, myAccount.getBalance());
    }


    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int dollars) throws Throwable {
        Teller teller = new Teller();
        teller.withdrawFrom(myAccount, dollars);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
