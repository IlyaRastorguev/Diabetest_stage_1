package com.diabetest.presentation.view;

import android.os.Bundle;

import com.diabetest.R;
import com.diabetest.domain.MainThreadImpl;
import com.diabetest.domain.ThreadExecutorImpl;
import com.diabetest.presentation.presentors.StartPresenter;

public class StartActivity extends BaseActivityImpl {

    private StartPresenter startPresenter;

    private static final int LAYOUT_ID = R.layout.start_activity;

    public StartActivity() {
        super(LAYOUT_ID);

        startPresenter = new StartPresenter(
                ThreadExecutorImpl.getExcecutor(),
                MainThreadImpl.getMainThread(),
                this
        );
    }
}
