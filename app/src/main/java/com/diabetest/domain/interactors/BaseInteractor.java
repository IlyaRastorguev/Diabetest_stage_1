package com.diabetest.domain.interactors;

public interface BaseInteractor {

    boolean isRunning();

    boolean isDone();

    void onFinish();

    void onError();

    void execute();

    void cancel();
}
