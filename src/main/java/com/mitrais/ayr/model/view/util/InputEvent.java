package com.mitrais.ayr.model.view.util;

import com.mitrais.ayr.dto.DataPayload;

import java.util.List;

public interface InputEvent {

    public void notify(List<DataPayload> data);
}
