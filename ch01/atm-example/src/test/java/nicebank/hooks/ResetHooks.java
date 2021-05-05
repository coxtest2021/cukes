package nicebank.hooks;

import cucumber.api.java.Before;
import nicebank.actors.BalanceStore;
import nicebank.actors.TransactionQueue;

public class ResetHooks
{
    @Before
    public void reset() {
        TransactionQueue.clear();
        BalanceStore.clear();
    }
}
