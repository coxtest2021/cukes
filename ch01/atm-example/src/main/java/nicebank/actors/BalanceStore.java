package nicebank.actors;

import nicebank.Money;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;
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
        File messagesFolder = new File(BALANCE_FOLDER);
        File[] messages = messagesFolder.listFiles();

        String message = "";

        if(messages != null && messages.length > 0)
        {
            Arrays.sort(messages, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return Integer.parseInt(o1.getName()) -
                            Integer.parseInt(o2.getName());
                }
            });

        }

        Scanner scanner = null;

        try {
            scanner = new Scanner(messages[0]);

            if(scanner.hasNextLine())
            {
                message = scanner.nextLine();
                scanner.close();
            } else
            {
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new Money(message);
    }
}
