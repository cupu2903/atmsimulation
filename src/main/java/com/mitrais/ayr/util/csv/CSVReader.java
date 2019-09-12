package com.mitrais.ayr.util.csv;

import com.mitrais.ayr.persistence.domain.Account;
import com.mitrais.ayr.persistence.domain.AccountData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

public class CSVReader {
    public static void read(String csvFile) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                if (line != "\n") {
                    String[] acct = line.split(cvsSplitBy);
                    System.out.println(Arrays.toString(acct));
                    Account account = new Account(acct[3], acct[1], acct[0], new BigDecimal(acct[2]));
                    AccountData.account.put(account.getAcctNo(), account);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
