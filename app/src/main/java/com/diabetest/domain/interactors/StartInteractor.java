package com.diabetest.domain.interactors;

import com.diabetest.domain.Executor;
import com.diabetest.domain.MainThread;
import com.diabetest.domain.repository.AbstractRepository;
import com.diabetest.domain.repository.LoginRepo;
import com.diabetest.model.OperationStatus;

public class StartInteractor extends AbstractInteractor {

    private final CallBack CALL_BACK;
    private final AbstractRepository REPOSITORY;

    public StartInteractor(Executor executor, MainThread mainThread, CallBack callBack, AbstractRepository repository) {
        super(executor, mainThread);

        CALL_BACK = callBack;
        REPOSITORY = repository;
    }

    private void goForward() {
        operationStatus = OperationStatus.DONE;

        mThread.doPost(new Runnable() {
            @Override
            public void run() {
                CALL_BACK.onPositive();
            }
        });
    }

    private void needLogIn() {
        operationStatus = OperationStatus.DONE;

        mThread.doPost(new Runnable() {
            @Override
            public void run() {
                CALL_BACK.onNegative();
            }
        });
    }

    @Override
    public void onError() {
        operationStatus = OperationStatus.ERROR;

        CALL_BACK.onError();
    }

    @Override
    public void run() {
        operationStatus = OperationStatus.RUNNING;

        if (((LoginRepo) REPOSITORY).checkLogin()) {
            goForward();
        } else {
            needLogIn();
        }
    }
}
