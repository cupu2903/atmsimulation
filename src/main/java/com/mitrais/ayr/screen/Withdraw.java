package com.mitrais.ayr.screen;

import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.dto.ResponseDto;
import com.mitrais.ayr.dto.WithdrawDto;
import com.mitrais.ayr.model.domain.Account;
import com.mitrais.ayr.model.domain.UserSession;
import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.OptionInput;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.model.view.util.EnumViewUtil;
import com.mitrais.ayr.model.view.util.ScreenGenerator;
import com.mitrais.ayr.model.view.util.Workflow;
import com.mitrais.ayr.util.BusinessValidator;
import com.mitrais.ayr.util.ResponseHandler;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Withdraw extends UIAdapter {

    @Override
    public Screen construct() {
        Screen sc = new Screen();
        sc.setScreenId("2");
        sc.setScreenName("Withdraw");

        List<OptionInput> optionInputs = new ArrayList<>();
        optionInputs.add(new OptionInput("1", "10", "1. $10", EnumViewUtil.ActionType.SELECTED, null));
        optionInputs.add(new OptionInput("2", "50", "2. $50", EnumViewUtil.ActionType.SELECTED, null));
        optionInputs.add(new OptionInput("3", "100", "3. $100", EnumViewUtil.ActionType.SELECTED, null));
        Component otherNominal = new Component("211", EnumViewUtil.ComponentType.FORM, "Enter amount to withdraw: ", null, null, null);
        otherNominal.setFixedLength(false);
        otherNominal.setInputType(1);
        otherNominal.setMinLength(2);
        otherNominal.setMaxLength(4);
        optionInputs.add(new OptionInput("4", null, "4. Other", EnumViewUtil.ActionType.INPUT, otherNominal));
        optionInputs.add(new OptionInput("0", null, "5. Back", EnumViewUtil.ActionType.GO, null));
        Component selectNominal = new Component("21", EnumViewUtil.ComponentType.SELECTION, "Please choose option[5]:", null, optionInputs, "");
        List<Component> comp = new ArrayList<>();
        comp.add(selectNominal);
        sc.setComponent(comp);
        return sc;
    }

    @Override
    public void responseHandler(List<DataPayload> dp) {
        DataPayload data = dp.get(0);
        if (data.getType().equals(1)) {
            UIAdapter nextFlow = Workflow.getNextFlow(data.getId());
            new ScreenGenerator(nextFlow).generate();
        } else {
            System.out.println(data.toString());
            BusinessValidator bv = new BusinessValidator();
            String respCode = bv.WithdrawValidator(data.getValue());
            if (respCode.equals("00")) {
                BigDecimal withdraw = new BigDecimal(data.getValue());
                WithdrawDto withdrawDto = new WithdrawDto();
                withdrawDto.setNominal(withdraw);
                withdrawDto.setTrxDate(LocalDateTime.now());
                ResponseDto<WithdrawDto> respDto = new ResponseDto<>();
                Account accountCache = UserSession.getAccountCache();
                BigDecimal subtract = accountCache.getBalance().subtract(withdrawDto.getNominal());
                if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                    respDto.setRespCode("31");
                    respDto.setMessage("Insufficient Funds");
                    System.out.println(ResponseHandler.getMessage(respDto.getRespCode()));
                } else {
                    accountCache.setBalance(subtract);
                    withdrawDto.setBalance(subtract);
                    respDto.setRespCode("00");
                    SummaryScreen ss = new SummaryScreen(withdraw, withdrawDto.getBalance());
                    new ScreenGenerator(ss).generate();
                }
            } else {
                System.out.println(ResponseHandler.getMessage(respCode));
            }
        }
    }

}
