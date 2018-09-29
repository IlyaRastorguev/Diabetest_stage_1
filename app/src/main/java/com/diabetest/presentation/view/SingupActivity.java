package com.diabetest.presentation.view;

import com.diabetest.R;
import com.diabetest.domain.MainThreadImpl;
import com.diabetest.domain.ThreadExecutorImpl;
import com.diabetest.presentation.presentors.SingupPresenter;

public class SingupActivity extends BaseActivityImpl {

    private static final int LAYOUT_ID = R.layout.singin_screen;

    public SingupActivity() {
        super(LAYOUT_ID);

        setPresenter(new SingupPresenter(
                ThreadExecutorImpl.getExcecutor(),
                MainThreadImpl.getMainThread(),
                this)
        );
    }
}
