package com.diabetest.presentation.view;

import android.os.Bundle;

import com.diabetest.R;
import com.diabetest.domain.MainThreadImpl;
import com.diabetest.domain.ThreadExecutorImpl;
import com.diabetest.presentation.presentors.StartPresenter;

public class StartActivity extends BaseActivityImpl {

    private StartPresenter startPresenter;

    public StartActivity(int layoutId) {
        super(layoutId);

        startPresenter = new StartPresenter(
                ThreadExecutorImpl.getExcecutor(),
                MainThreadImpl.getMainThread(),
                this
        );
    }
}
