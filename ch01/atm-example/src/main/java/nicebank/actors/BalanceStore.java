package nicebank.actors;

import nicebank.Money;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BalanceStore
{
    private static String BALANCE_FOLDER = "./balance";
    private static String BALANCE_FILE_PATH = "%s/%s";
    private static String FILE_NAME = "balance";

    public static void clear()
    {
        new File(BALANCE_FOLDER).delete();
        setBalance(new Money(0,0));
    }

    public static void setBalance(Money newBalance)
    {
        String messageFilePath
                = String.format(BALANCE_FILE_PATH, BALANCE_FOLDER, FILE_NAME);

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(messageFilePath, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        writer.println(newBalance.toString());
        writer.close();
    }

    public static Money getBalance()
    {
        File balanceFile = new File(BALANCE_FILE_PATH + "/balance");

        Scanner scanner = null;

        try {
            scanner = new Scanner(balanceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Money balance = new Money(scanner.nextLine());
        scanner.close();

        return balance;
    }
}
