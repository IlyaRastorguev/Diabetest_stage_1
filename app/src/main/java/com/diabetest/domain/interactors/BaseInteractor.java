package com.diabetest.domain.interactors;

public interface BaseInteractor {

    boolean isRunning();

    boolean isOk();

    void onFinish();

    void onError();

    void execute();

    void cancel();
}
