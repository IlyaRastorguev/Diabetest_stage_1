package com.diabetest.presentation.view;


import com.diabetest.R;
import com.diabetest.domain.MainThreadImpl;
import com.diabetest.domain.ThreadExecutorImpl;
import com.diabetest.presentation.presentors.LoginPresenter;

public class LoginActivity extends BaseActivityImpl {

    private static final int LAYOUT_ID = R.layout.login_screen;

    public LoginActivity() {
        super(LAYOUT_ID);

        setPresenter(new LoginPresenter(
                ThreadExecutorImpl.getExcecutor(),
                MainThreadImpl.getMainThread(),
                this)
        );
    }
}
