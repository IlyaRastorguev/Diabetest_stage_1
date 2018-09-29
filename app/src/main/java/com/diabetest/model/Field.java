package com.diabetest.model;

public class Field<T> {

    private int fieldId;

    private State state;

    private String errorMessage;

    private T value;

    private FieldPattern fieldPattern;

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public FieldPattern getFieldPattern() {
        return fieldPattern;
    }

    public void setFieldPattern(FieldPattern fieldPattern) {
        this.fieldPattern = fieldPattern;
    }
}
