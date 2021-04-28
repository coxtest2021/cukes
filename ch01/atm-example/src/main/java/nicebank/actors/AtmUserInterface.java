package nicebank.actors;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.By;

public class AtmUserInterface implements Teller{

    private CashSlot cashSlot;
    private EventFiringWebDriver webDriver;
    private static final int PORT = 8887;


    public AtmUserInterface(CashSlot cashSlot)
    {
        this.webDriver = new EventFiringWebDriver(new FirefoxDriver());
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int dollars) {
        try
        {
            webDriver.get("http://localhost:" + PORT);
            webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        } finally {
            webDriver.close();
        }
    }
}
