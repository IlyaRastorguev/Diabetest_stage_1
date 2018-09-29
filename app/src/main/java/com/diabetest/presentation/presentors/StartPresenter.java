package com.diabetest.presentation.presentors;


import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;
import com.diabetest.domain.interactors.AbstractInteractor.CallBack;
import com.diabetest.domain.interactors.StartInteractor;
import com.diabetest.domain.repository.LoginRepoImpl;
import com.diabetest.model.startScreen.StartScreen;
import com.diabetest.presentation.view.AuthActivity;
import com.diabetest.presentation.view.StartActivity;

public class StartPresenter extends AbstractPresenter<StartActivity, StartScreen> implements BasePresenter, CallBack {

    @Override
    public void resolveScreen() {

    }

    @Override
    public void validateField(String value, String pattern, int id) {
    }

    public StartPresenter(Executor executor, MainThread mainThread, StartActivity view) {
        super(executor, mainThread, view, new StartScreen());
    }
    @Override
    public void onStart() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onNegative() {

    }

    @Override
    public void onPositive() {
        getActivity().next(AuthActivity.class, null);
    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onResume() {
        StartInteractor startInteractor = new StartInteractor(executor, mainThread, this, new LoginRepoImpl());

        startInteractor.run();
    }
}
