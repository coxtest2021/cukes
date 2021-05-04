package nicebank.actors;

import nicebank.Money;
import nicebank.actors.Account;
import nicebank.actors.CashSlot;

public class AutomatedTeller implements Teller{

    private Account account;
    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot, Account account)
    {
        this.cashSlot = cashSlot;
        this.account = account;
    }

    public void withdrawFrom(Account account, int dollars)
    {
        cashSlot.dispense(dollars);
        account.debit(dollars);
    }
}
