package nicebank.actors;

import nicebank.Money;

public class Account {
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
