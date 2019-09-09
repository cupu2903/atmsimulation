package com.mitrais.ayr.model.view;

import java.util.List;

public class Screen {

    private String screenId;
    private String screenName;
    private List<Component> component;

    public Screen() {
    }

    public Screen(String screenId, String screenName, List<Component> component) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.component = component;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<Component> getComponent() {
        return component;
    }

    public void setComponent(List<Component> component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "screenId='" + screenId + '\'' +
                ", screenName='" + screenName + '\'' +
                ", component=" + component +
                '}';
    }
}
