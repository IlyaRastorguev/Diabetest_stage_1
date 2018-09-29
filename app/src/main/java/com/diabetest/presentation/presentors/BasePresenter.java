package com.diabetest.presentation.presentors;

public interface BasePresenter {

    void onStart();

    void onFinish();

    void onCancel();

    void onResume();

    void resolveScreen();

    void validateField(String value, String pattern, int id);

}
