package com.diabetest.domain.interactors;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;
import com.diabetest.model.OperationStatus;

public abstract class AbstractInteractor implements BaseInteractor {

    public interface CallBack {

        void onNegative();

        void onPositive();

        void onError();

    }

    protected Executor executor;
    protected MainThread mThread;

    private Exception e;

    protected volatile OperationStatus operationStatus;

    public AbstractInteractor(Executor executor, MainThread mThread) {
        this.executor = executor;
        this.mThread = mThread;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public abstract void run();

    @Override
    public boolean isRunning() {
        return operationStatus == OperationStatus.RUNNING;
    }

    @Override
    public boolean isDone() {
        return operationStatus == OperationStatus.DONE;
    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void execute() {
        operationStatus = OperationStatus.RUNNING;

        executor.execute(this);
    }

    @Override
    public void cancel() {

    }
}
