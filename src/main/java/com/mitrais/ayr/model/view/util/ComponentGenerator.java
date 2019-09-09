package com.mitrais.ayr.model.view.util;

import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.OptionInput;
import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.util.InputValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.mitrais.ayr.App.sc;

public class ComponentGenerator {

    public DataPayload generateForm(Component comp) {

        System.out.println(comp.getCompName());
        String input = sc.next();
        if (!InputValidator.validate(input.toString())) {
            System.out.println("Please Input Number [0-9] only");
            return generateForm(comp);
        } else {
            return new DataPayload(comp.getCompId(), input,0);
        }
    }

    public DataPayload generateInfo(Component comp) {
        String sb = null;
        if(comp.getDefaultValue()!=null){
            switch (comp.getDefaultValue()){
                case "date":
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
                    sb = (formatter.format(now));
            }
        }else{
            sb = (comp.getValue());
        }
        return new DataPayload(comp.getCompId(),sb,0);
    }

    public DataPayload generateSelection(Component comp){
        StringBuilder sb = new StringBuilder();

        for (OptionInput opt : comp.getOption()) {
            sb.append(opt.getTitle());
            sb.append("\n");
        }
        sb.append(comp.getCompName());
        System.out.println(sb.toString());
        int menuChoice;
        do {
            menuChoice = sc.nextInt();
        } while (menuChoice < 1 || menuChoice > comp.getOption().size());
//        System.out.println("menu choice :" + menuChoice);
        OptionInput selected = comp.getOption().get(menuChoice - 1);
//        System.out.println("selected :" + selected.toString());
        DataPayload dp;
        switch (selected.getAction()) {
            case INPUT:
                dp = generateForm(selected.getComp());
                break;
            case SELECTED:
                dp = new DataPayload(selected.getId(), selected.getValue(),0);
                break;
            case GO:
                dp = new DataPayload(selected.getId(), selected.getValue(),0);
                dp.setType(1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + selected.getAction());
        }
//        System.out.println("data payload return " + dp.toString());
        return dp;
    }
}
