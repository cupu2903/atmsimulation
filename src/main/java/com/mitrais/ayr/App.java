package com.mitrais.ayr;

import com.mitrais.ayr.model.domain.AccountData;
import com.mitrais.ayr.model.view.util.InputEvent;
import com.mitrais.ayr.model.view.util.ScreenGenerator;
import com.mitrais.ayr.screen.Login;
import com.mitrais.ayr.screen.MainMenu;
import com.mitrais.ayr.util.ResponseHandler;
import com.mitrais.ayr.util.csv.CSVReader;

import javax.annotation.Resource;
import java.util.Scanner;

/**
 * ATM Simulation
 */

public class App {
    public static Scanner sc = new Scanner(System.in);
    private static int invalidCount = 0;
    private InputEvent ie;

    public static void main(String[] args) {
//        AccountData.init();
        CSVReader.read("src/main/resources/account.csv");
        run();
    }

    private static void run(){
        String respCode = Login.showLoginScreen(sc);
        handleAuth(respCode);
    }

    private static void handleAuth(String respCode) {
        if (!respCode.equals("00")) {
            if (respCode.equals("55")) {
                invalidCount++;
            }
            if (invalidCount > 3) {
                respCode = "75";
            }
            System.out.println(ResponseHandler.getMessage(respCode));
            run();
        } else {
            invalidCount = 0;
            MainMenu main = new MainMenu();
            new ScreenGenerator(main).generate();
        }
    }
}
