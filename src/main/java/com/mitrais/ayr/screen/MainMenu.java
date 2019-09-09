package com.mitrais.ayr.screen;

import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.OptionInput;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.model.view.util.ScreenGenerator;
import com.mitrais.ayr.model.view.util.Workflow;

import java.util.ArrayList;
import java.util.List;

import static com.mitrais.ayr.model.view.util.EnumViewUtil.ActionType.*;
import static com.mitrais.ayr.model.view.util.EnumViewUtil.ComponentType.*;

public class MainMenu extends UIAdapter {

    @Override
    public Screen construct() {
        Screen sc= new Screen();
        sc.setScreenId("0");
        sc.setScreenName("Main Menu");

        OptionInput wd = new OptionInput("1","1","1. Withdraw", GO, null);
        OptionInput fund = new OptionInput("2","2","2. Fund", GO, null);
        OptionInput exit = new OptionInput("3","3","3. Exit", GO, null);
        List<OptionInput> oi = new ArrayList<>();
        oi.add(wd);
        oi.add(fund);
        oi.add(exit);
        Component menu = new Component("21", SELECTION,"Please choose option[3]: ", null, oi, null);
        List<Component> comps = new ArrayList<>();
        comps.add(menu);
        sc.setComponent(comps);
        return sc;
    }

    @Override
    public void notify(List<DataPayload> data) {
        UIAdapter nextFlow = Workflow.getNextFlow(data.get(0).getId());
        new ScreenGenerator(nextFlow).generate();
    }
}
