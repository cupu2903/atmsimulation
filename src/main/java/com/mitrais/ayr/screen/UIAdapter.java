package com.mitrais.ayr.screen;

import com.mitrais.ayr.model.view.Screen;
import com.mitrais.ayr.model.view.util.InputEvent;

import javax.xml.crypto.Data;

public abstract class UIAdapter implements InputEvent {

    public abstract Screen construct();
}
