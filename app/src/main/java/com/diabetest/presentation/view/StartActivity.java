package com.diabetest.presentation.view;

import android.content.Intent;
import android.os.Bundle;

import com.diabetest.R;
import com.diabetest.domain.MainThreadImpl;
import com.diabetest.domain.ThreadExecutorImpl;
import com.diabetest.presentation.presentors.StartPresenter;

public class StartActivity extends BaseActivityImpl {

    private static final int LAYOUT_ID = R.layout.start_activity;

    public StartActivity() {
        super(LAYOUT_ID);

        setPresenter(new StartPresenter(
                ThreadExecutorImpl.getExcecutor(),
                MainThreadImpl.getMainThread(),
                this
        ));

    }

    @Override
    public void next(Class<? extends BaseActivityImpl> activityClass, Bundle bundle) {
        Intent intent = new Intent(StartActivity.this, activityClass);
        startActivity(intent);

    }

    @Override
    public void next() {

    }
}
