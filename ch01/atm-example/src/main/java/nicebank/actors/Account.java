package nicebank.actors;

import nicebank.Money;
import org.javalite.activejdbc.Model;

public class Account extends Model {

    private TransactionQueue queue = new TransactionQueue();

    public Account(){}

    public Account(int number)
    {
        setInteger("number", number);
        setString("balance", "0.00");
    }

    public void credit(Money amount)
    {
        queue.write("+" + amount.toString() + "," + getNumber());
    }

    public void debit(int dollars)
    {
        Money amount = new Money(dollars, 0);
        queue.write("-" + amount.toString() + "," + getNumber());
    }

    public Money getBalance()
    {
        return new Money(getString("balance"));
    }

    public void setBalance(Money amount)
    {
        setString("balance", amount.toString().substring(1));
        saveIt();
    }

    private int getNumber()
    {
        return getInteger("number");
    }
}
