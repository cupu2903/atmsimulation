package com.mitrais.ayr.model.view;

import com.mitrais.ayr.model.view.util.EnumViewUtil;

import java.util.List;

public class Component {

    private String compId;
    private EnumViewUtil.ComponentType compType;
    private String compName;
    private String defaultValue;
    private List<OptionInput> option;
    private String value;
    private int inputType;
    private int minLength;
    private int maxLength;
    private boolean fixedLength;

    public Component(String compId, EnumViewUtil.ComponentType compType, String compName, String defaultValue, List<OptionInput> option, String value) {
        this.compId = compId;
        this.compType = compType;
        this.compName = compName;
        this.defaultValue = defaultValue;
        this.option = option;
        this.value = value;
    }

    public int getInputType() {
        return inputType;
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isFixedLength() {
        return fixedLength;
    }

    public void setFixedLength(boolean fixedLength) {
        this.fixedLength = fixedLength;
    }

    public EnumViewUtil.ComponentType getCompType() {
        return compType;
    }

    public void setCompType(EnumViewUtil.ComponentType compType) {
        this.compType = compType;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }


    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<OptionInput> getOption() {
        return option;
    }

    public void setOption(List<OptionInput> option) {
        this.option = option;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
