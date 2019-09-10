package com.mitrais.ayr.screen;

import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.dto.FundTransferDto;
import com.mitrais.ayr.dto.ResponseDto;
import com.mitrais.ayr.model.domain.Account;
import com.mitrais.ayr.model.domain.UserSession;
import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.OptionInput;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.model.view.util.EnumViewUtil;
import com.mitrais.ayr.model.view.util.ScreenGenerator;
import com.mitrais.ayr.service.AccountService;
import com.mitrais.ayr.service.impl.AccountServiceImpl;
import com.mitrais.ayr.util.ResponseHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.mitrais.ayr.model.view.util.EnumViewUtil.ComponentType.INFO;
import static com.mitrais.ayr.model.view.util.EnumViewUtil.ComponentType.SELECTION;

public class FundTransferConf extends UIAdapter {

    FundTransferDto dto;

    public FundTransferConf(FundTransferDto dto) {
        this.dto = dto;
    }

    @Override
    public Screen construct() {
        Screen sc = new Screen();
        sc.setScreenId("21");
        sc.setScreenName("Fund Transfer Confimation Screen");
        Component destAcct = new Component("211", INFO, "Destination Account : ", null, null, dto.getDestAccount());
        Component amount = new Component("212", INFO, "Transfer Amount : $", null, null, String.valueOf(dto.getNominal()));
        Component refNumber = new Component("213", INFO, "Reference Number : ", null, null, dto.getRefNo());

        OptionInput goTrans = new OptionInput("4", "4", "1.Confirm Trx", EnumViewUtil.ActionType.GO, null);
        OptionInput goBack = new OptionInput("99", "99", "2.Cancel Trx", EnumViewUtil.ActionType.GO, null);
        List<OptionInput> loi = new ArrayList<>();
        loi.add(goTrans);
        loi.add(goBack);
        Component option = new Component("34", SELECTION, "Choose option[2]:", null, loi, null);

        List<Component> lc = new ArrayList<>();
        lc.add(destAcct);
        lc.add(amount);
        lc.add(refNumber);
        lc.add(option);
        sc.setComponent(lc);
        return sc;
    }

    @Override
    public void responseHandler(List<DataPayload> data) {
        AccountService as = new AccountServiceImpl();
        FundTransferDto dto = new FundTransferDto();
        BigDecimal trfAmount = new BigDecimal(data.get(1).getValue());
        dto.setDestAccount(data.get(0).getValue());
        dto.setNominal(trfAmount);
        dto.setRefNo(data.get(2).getValue());
        Account destAccount = as.findByID(dto.getDestAccount());
        if (destAccount != null) {
            ResponseDto<FundTransferDto> respDto = new ResponseDto<>();
            Account sourceAcct = UserSession.accountCache;
            BigDecimal subtract = sourceAcct.getBalance().subtract(dto.getNominal());
            if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                respDto.setRespCode("31");
                respDto.setMessage("Insufficient Funds");
                System.out.println(ResponseHandler.getMessage(respDto.getRespCode()));
            } else {
                destAccount.setBalance(destAccount.getBalance().add(dto.getNominal()));
                sourceAcct.setBalance(subtract);
                dto.setBalance(subtract);
                respDto.setRespCode("00");
                FundTrfScreen nextFlow = new FundTrfScreen(dto);
                new ScreenGenerator(nextFlow).generate();
            }
        } else {
            System.out.println(ResponseHandler.getMessage("14"));
        }
    }
}
