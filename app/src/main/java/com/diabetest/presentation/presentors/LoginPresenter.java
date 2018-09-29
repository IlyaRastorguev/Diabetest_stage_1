package com.diabetest.presentation.presentors;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;
import com.diabetest.domain.interactors.AbstractInteractor;
import com.diabetest.model.loginScreen.LoginScreen;
import com.diabetest.presentation.view.LoginActivity;

public class LoginPresenter extends FieldValidationPresenter<LoginActivity, LoginScreen> implements AbstractInteractor.CallBack {

    public LoginPresenter(Executor executor, MainThread mainThread, LoginActivity activity) {
        super(executor, mainThread, activity, new LoginScreen());
    }

    @Override
    public void onNegative() {

    }

    @Override
    public void onPositive() {

    }

    @Override
    public void onError() {

    }
}
