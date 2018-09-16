package com.diabetest.presentation.presentors;

import android.view.View;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;

public class StartPresenter extends AbstractPresenter implements BasePresenter {

    private BasicView view;

    public  StartPresenter(Executor executor, MainThread mainThread, BasicView view) {
        super(executor, mainThread);

        this.view = view;
    }
    @Override
    public void onStart() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onCancel() {

    }
}
