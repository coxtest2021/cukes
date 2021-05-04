package nicebank.actors;

import nicebank.Money;

public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process()
    {
        do
        {
            String message = queue.read();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            if(message.length() > 0)
            {
                Money balance = BalanceStore.getBalance();
                Money transactionAmount = new Money(message);
            }
        } while(true);
    }
}
