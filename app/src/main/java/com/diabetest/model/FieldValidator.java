package com.diabetest.model;

public class FieldValidator {

    public static boolean validate(String value, String pattern) {
        final boolean result = value.matches(pattern);

        return result;
    }

}
