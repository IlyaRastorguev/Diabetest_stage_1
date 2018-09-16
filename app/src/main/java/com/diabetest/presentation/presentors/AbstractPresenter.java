package com.diabetest.presentation.presentors;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;

public class AbstractPresenter {

    public interface BasicView {

        void showProgress();

        void showError();

        void next();

        void previous();

        void doAction();
    }

    protected Executor executor;
    protected MainThread mainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
    }
}
