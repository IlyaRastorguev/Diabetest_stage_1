package com.diabetest.presentation.presentors;

import android.os.Bundle;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;
import com.diabetest.model.AbstractScreen;
import com.diabetest.presentation.view.BaseActivityImpl;

public abstract class AbstractPresenter<A extends BaseActivityImpl, S extends AbstractScreen> extends CorePresenter<A, S> {

    public interface BasicView {

        void showProgress();

        void showError(int id);

        void next(Class<? extends BaseActivityImpl> activityClass, Bundle bundle);

        void next();

        void previous();

        void doAction();

        void init();

        void initFragment(int containerId, Class<BasicFragment> fragmentClass);
    }

    public interface BasicFragment {

        void doAction();

        void init();

        void showError();
    }

    protected Executor executor;
    protected MainThread mainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread, A activity, S screen) {

        super(activity, screen);

        this.executor = executor;
        this.mainThread = mainThread;
    }
}
