package com.mitrais.ayr;

import com.mitrais.ayr.model.domain.AccountData;
import com.mitrais.ayr.model.domain.UserSession;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.model.view.util.InputEvent;
import com.mitrais.ayr.model.view.util.ScreenGenerator;
import com.mitrais.ayr.screen.*;
import com.mitrais.ayr.util.ResponseHandler;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static Scanner sc = new Scanner(System.in);
    private static int invalidCount = 0;
    private InputEvent ie;

    public static void main(String[] args) {
        AccountData.init();
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
