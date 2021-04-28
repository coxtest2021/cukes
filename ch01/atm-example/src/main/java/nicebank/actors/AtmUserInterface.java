package nicebank.actors;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.By;

public class AtmUserInterface implements Teller{

    private CashSlot cashSlot;
    private EventFiringWebDriver webDriver;


    public AtmUserInterface(CashSlot cashSlot)
    {
        this.webDriver = new EventFiringWebDriver(new FirefoxDriver());
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account account, int dollars) {
        try
        {
            webDriver.get("http://localhost:9988");
            webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        } finally {
            webDriver.close();
        }
    }
}
