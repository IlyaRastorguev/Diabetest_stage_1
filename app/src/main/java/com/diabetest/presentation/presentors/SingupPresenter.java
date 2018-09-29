package com.diabetest.presentation.presentors;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;
import com.diabetest.domain.interactors.AbstractInteractor;
import com.diabetest.model.singupScreen.SingupScreen;
import com.diabetest.presentation.view.SingupActivity;

public class SingupPresenter extends FieldValidationPresenter<SingupActivity, SingupScreen> implements AbstractInteractor.CallBack {

    public SingupPresenter(Executor executor, MainThread mainThread, SingupActivity activity) {
        super(executor, mainThread, activity, new SingupScreen());
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
