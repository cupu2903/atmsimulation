package com.mitrais.ayr.model.view.util;

import com.mitrais.ayr.model.view.Component;
import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.dto.DataPayload;
import com.mitrais.ayr.screen.UIAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScreenGenerator {
    UIAdapter ie;

    public ScreenGenerator(UIAdapter ie) {
        this.ie = ie;
    }

    public void generate() {
        Screen screen = ie.construct();
        System.out.println(screen.getScreenName());
        List<DataPayload> ldp = new ArrayList<>();
        for (Component comp : screen.getComponent()) {
            switch (comp.getCompType()) {
                case FORM:
                    ldp.add(new ComponentGenerator().generateForm(comp));
                    break;
                case SELECTION:
                    DataPayload dp = new ComponentGenerator().generateSelection(comp);
                    ldp.add(dp);
                    break;
                case INFO:
                    DataPayload dpi = new ComponentGenerator().generateInfo(comp);
                    StringBuilder sb = new StringBuilder();
                    sb.append(comp.getCompName());
                    sb.append(dpi.getValue());
                    ldp.add(dpi);
                    System.out.println(sb.toString());
                default:
            }
        }
        ie.responseHandler(ldp);
    }
}
