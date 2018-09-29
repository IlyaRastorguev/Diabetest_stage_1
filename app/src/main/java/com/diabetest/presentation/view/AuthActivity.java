package com.diabetest.presentation.view;

import android.content.Intent;
import android.os.Bundle;

import com.diabetest.R;
import com.diabetest.presentation.presentors.AuthPresenter;

public class AuthActivity extends BaseActivityImpl {

    private static final int LAYOUT_ID = R.layout.auth_screen;


    public AuthActivity() {
        super(LAYOUT_ID);

        setPresenter(new AuthPresenter(this));
    }

    @Override
    public void next(Class<? extends BaseActivityImpl> activityClass, Bundle bundle) {
        Intent intent = new Intent(AuthActivity.this, activityClass);
        startActivity(intent);
    }

    @Override
    public void init() {
        presenter.resolveScreen();
    }
}
