package nicebank.actors;

import nicebank.actors.Account;
import nicebank.actors.CashSlot;

public class AutomatedTeller {

    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot)
    {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int dollars)
    {
        cashSlot.dispense(dollars);
    }
}
