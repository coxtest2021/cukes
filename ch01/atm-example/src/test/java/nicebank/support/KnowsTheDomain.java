package nicebank.support;

import nicebank.actors.Account;
import nicebank.actors.CashSlot;
import nicebank.actors.Teller;

public class KnowsTheDomain {

    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;

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

    public Teller getTeller()
    {
        if(teller == null)
        {
            teller = new Teller(this.getCashSlot());
        }
        return teller;
    }
}
