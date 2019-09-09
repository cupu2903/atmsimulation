package com.mitrais.ayr.model.view.util;

import com.mitrais.ayr.screen.*;

public class Workflow {

    public static UIAdapter getNextFlow(String screenId){
        switch (screenId){
            case "0":
                return new MainMenu();
            case "1":
                return new Withdraw();
            case "2":
                return new FundTransferInqScreen();
            default:
                System.exit(0);
                return null;
        }
    }
}
