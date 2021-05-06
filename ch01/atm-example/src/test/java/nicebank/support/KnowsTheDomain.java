package nicebank.support;

import nicebank.actors.*;
import org.javalite.activejdbc.Base;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheDomain {

    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;
    private EventFiringWebDriver webDriver;

    public KnowsTheDomain()
    {
        if (!Base.hasConnection()){
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
        }
    }

    public EventFiringWebDriver getWebDriver()
    {
        if(webDriver == null)
        {
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }
        return webDriver;
    }

    public Account getMyAccount() {
        if(!Base.hasConnection())
        {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/bank",
                    "teller", "password"
            );
        }
        Account account = Account.findFirst("number = ?", "1234");

        return account;
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
            teller = new AtmUserInterface(getWebDriver());
        }
        return teller;
    }
}
