package nicebank.actors;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.By;

public class AtmUserInterface implements Teller{

    private CashSlot cashSlot;
    private EventFiringWebDriver webDriver;
    private static final int PORT = 8887;


    public AtmUserInterface(EventFiringWebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void withdrawFrom(Account account, int dollars) {
        try
        {
            webDriver.get("http://localhost:" + PORT);
            webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
