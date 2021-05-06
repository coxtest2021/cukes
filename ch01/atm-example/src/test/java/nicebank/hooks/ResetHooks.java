package nicebank.hooks;

import cucumber.api.java.Before;
import nicebank.Money;
import nicebank.actors.Account;
import nicebank.actors.TransactionQueue;

public class ResetHooks
{
    @Before
    public void reset() {
        TransactionQueue.clear();
        // reset balance, so that test execution is deterministic.
        Account account = Account.findFirst("number = ?", "1234");
        account.setBalance(new Money());
    }
}
