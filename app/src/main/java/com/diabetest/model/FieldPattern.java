package com.diabetest.model;

public enum FieldPattern {

    NAME("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"),
    EMAIL("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"),
    PASSWORD("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");

    private String pattern;

    public String getPattern() {
        return pattern;
    }

    FieldPattern(String value) {
        this.pattern = value;
    }

}
