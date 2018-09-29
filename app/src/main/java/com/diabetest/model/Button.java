package com.diabetest.model;

import java.util.HashMap;

public class Button {

    private int buttonId;

    private HashMap props;

    private ActionType actionType;

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public HashMap getProps() {
        return props;
    }

    public void setProps(HashMap props) {
        this.props = props;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}
