package com.diabetest.presentation.presentors;

import com.diabetest.model.authScreen.AuthScreen;
import com.diabetest.presentation.view.AuthActivity;


public class AuthPresenter extends CorePresenter<AuthActivity, AuthScreen> implements BasePresenter {

    public AuthPresenter(AuthActivity baseActivity) {
        super(baseActivity, new AuthScreen());
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onResume() {
        resolveScreen();
    }

    @Override
    public void resolveScreen() {
        this.initButtons();
    }

    @Override
    public void validateField(String value, String pattern, int id) {
    }

}
