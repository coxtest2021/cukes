package nicebank;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nicebank.transforms.MoneyConverter;
import org.junit.Assert;

public class Steps {

    private KnowsTheDomain helper;

    public Steps()
    {
        helper = new KnowsTheDomain();
    }

    class KnowsTheDomain
    {
        private Account myAccount;
        private CashSlot cashSlot;

        public Account getMyAccount() {
            if(myAccount == null)
            {
                myAccount = new Account();
            }
            return myAccount;
        }

        public CashSlot getCashSlot()
        {
            if(cashSlot == null)
            {
                cashSlot = new CashSlot();
            }
            return cashSlot;
        }
    }

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

    class Teller
    {
        private CashSlot cashSlot;

        public Teller(CashSlot cashSlot)
        {
            this.cashSlot = cashSlot;
        }

        public void withdrawFrom(Account account, int dollars)
        {
            cashSlot.dispense(dollars);
        }
    }

    class CashSlot
    {
        public int getContents()
        {
            return 0;
        }
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount)
            throws Throwable
    {
        helper.getMyAccount().deposit(amount);

        Assert.assertEquals("Incorrect account balance -",
                amount, helper.getMyAccount().getBalance());
    }


    @When("^I withdraw \\$(\\d+)$")
    public void iRequest$(int dollars) throws Throwable {
        Teller teller = new Teller();
        teller.withdrawFrom(helper.getMyAccount(), dollars);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().getContents());
    }


}
