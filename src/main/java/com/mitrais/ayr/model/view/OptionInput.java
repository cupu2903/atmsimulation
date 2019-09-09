package com.mitrais.ayr.model.view;

import com.mitrais.ayr.model.view.util.EnumViewUtil;

public class OptionInput {

    private String id;
    private String value;
    private String title;
    private EnumViewUtil.ActionType action;
    private Component comp;

    public OptionInput(String id, String value, String title, EnumViewUtil.ActionType action, Component comp) {
        this.id = id;
        this.value = value;
        this.title = title;
        this.action = action;
        this.comp = comp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public EnumViewUtil.ActionType getAction() {
        return action;
    }

    public void setAction(EnumViewUtil.ActionType action) {
        this.action = action;
    }

    public Component getComp() {
        return comp;
    }

    public void setComp(Component comp) {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return "OptionInput{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", title='" + title + '\'' +
                ", action=" + action +
                ", comp=" + comp +
                '}';
    }
}
