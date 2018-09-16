package com.diabetest.presentation.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.diabetest.presentation.presentors.AbstractPresenter;

public class BaseActivityImpl extends AppCompatActivity implements AbstractPresenter.BasicView {

    private int layoutId;

    public BaseActivityImpl(@NonNull int layoutId) {
        super();

        this.layoutId = layoutId;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

        doAction();
    }

    @Override
    protected void onStart() {
        super.onStart();

        setContentView(layoutId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void next() {

    }

    @Override
    public void previous() {

    }

    @Override
    public void doAction() {

    }
}
