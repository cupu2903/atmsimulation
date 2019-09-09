package com.mitrais.ayr.screen;

import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.dto.FundTransferDto;
import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.OptionInput;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.model.view.util.EnumViewUtil;

import java.util.ArrayList;
import java.util.List;

import static com.mitrais.ayr.model.view.util.EnumViewUtil.ComponentType.INFO;
import static com.mitrais.ayr.model.view.util.EnumViewUtil.ComponentType.SELECTION;

public class FundTrfScreen extends UIAdapter{
    FundTransferDto dto;

    public FundTrfScreen(FundTransferDto dto) {
        this.dto = dto;
    }

    @Override
    public Screen construct() {
        Screen sc = new Screen();
        sc.setScreenId("21");
        sc.setScreenName("Fund Transfer Summary");
        Component destAcct = new Component("211", INFO, "Destination Account : ", null, null, dto.getDestAcct());
        Component amount = new Component("212", INFO, "Transfer Amount : $", null, null, String.valueOf(dto.getAmount()));
        Component refNumber = new Component("213", INFO, "Reference Number : ", null, null, dto.getRefNo());
        Component balance = new Component("214", INFO, "Balance : $", null, null, String.valueOf(dto.getBalance()));

        OptionInput goTrans = new OptionInput("0", "0", "1.Transaction", EnumViewUtil.ActionType.GO, null);
        OptionInput goBack = new OptionInput("99", "99", "2.Exit", EnumViewUtil.ActionType.GO, null);
        List<OptionInput> loi = new ArrayList<>();
        loi.add(goTrans);
        loi.add(goBack);
        Component option = new Component("34", SELECTION, "Choose option[2]:", null, loi, null);

        List<Component> lc = new ArrayList<>();
        lc.add(destAcct);
        lc.add(amount);
        lc.add(refNumber);
        lc.add(balance);
        lc.add(option);
        sc.setComponent(lc);
        return sc;

    }

    @Override
    public void notify(List<DataPayload> data) {

    }
}
