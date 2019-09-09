package com.mitrais.ayr.screen;

import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.OptionInput;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.model.view.util.EnumViewUtil;
import com.mitrais.ayr.model.view.util.ScreenGenerator;
import com.mitrais.ayr.model.view.util.Workflow;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.mitrais.ayr.model.view.util.EnumViewUtil.ComponentType.*;

public class SummaryScreen extends UIAdapter {

    private final BigDecimal withdraw;
    private final BigDecimal balance;

    public SummaryScreen(final BigDecimal withdraw, final BigDecimal balance) {
        this.withdraw = withdraw;
        this.balance = balance;
    }

    @Override
    public Screen construct() {
        Screen sc = new Screen();
        sc.setScreenId("3");
        sc.setScreenName("Summary");

        String s = String.valueOf(withdraw);
        String x = String.valueOf(balance);

        Component trxDate = new Component("31", INFO, "Date :", "date", null, null);
        Component withdraw = new Component("32", INFO, "Withdraw : $", null, null, s);
        Component balance = new Component("33", INFO, "Balance : $", null, null, x);

        OptionInput goTrans = new OptionInput("0", "0", "1.Transaction", EnumViewUtil.ActionType.GO, null);
        OptionInput goBack = new OptionInput("99", "99", "2.Exit", EnumViewUtil.ActionType.GO, null);
        List<OptionInput> loi = new ArrayList<>();
        loi.add(goTrans);
        loi.add(goBack);
        Component option = new Component("34", SELECTION, "Choose option[2]:", null, loi, null);
        List<Component> comps = new ArrayList<>();
        comps.add(trxDate);
        comps.add(withdraw);
        comps.add(balance);
        comps.add(option);
        sc.setComponent(comps);
        return sc;
    }


    @Override
    public void notify(List<DataPayload> data) {
        UIAdapter nextFlow = Workflow.getNextFlow(data.get(3).getId());
        new ScreenGenerator(nextFlow).generate();
    }
}
