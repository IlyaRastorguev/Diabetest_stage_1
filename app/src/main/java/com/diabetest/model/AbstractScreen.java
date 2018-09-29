package com.diabetest.model;

import java.util.List;

public abstract class AbstractScreen {

    private List<Field> fields;

    private List<Button> buttons;

    private List<Text> texts;

    public List<Field> getFields() {
        return fields;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public List<Text> getTexts() {
        return texts;
    }

    protected abstract void initScreen();

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
