package nicebank.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.actors.TransactionProcessor;


public class BackgroundProcessHooks {
    private Thread transactionProcessorThread;

    @Before(order = 1)
    public void startBackgroundThread() {
        transactionProcessorThread = new Thread() {
            public void run() {
                TransactionProcessor processor = new TransactionProcessor();
                processor.process();
            }
        };

        transactionProcessorThread.start();
    }

    @After
    public void stopBackgroundThread() {
        transactionProcessorThread.interrupt();
    }
}