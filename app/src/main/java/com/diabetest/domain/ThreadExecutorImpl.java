package com.diabetest.domain;

import com.diabetest.domain.interactors.AbstractInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorImpl implements Executor {

    private static final int PULL_SIZE = 2;
    private static final int MAX_PULL_SIZE = 5;
    private static final int KEEP_ALIVE = 240;
    private static final BlockingQueue<Runnable> QUEUE = new LinkedBlockingQueue<>();
    private static final TimeUnit UNIT = TimeUnit.SECONDS;

    private ThreadPoolExecutor threadPoolExecutor;

    private static volatile ThreadExecutorImpl threadExecutorImpl;

    private ThreadExecutorImpl() {
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                if (!interactor.isRunning()) interactor.run();

                if (interactor.isDone()) interactor.onFinish();
                else interactor.onError();

            }
        });
    }

    private void createPool() {
        threadPoolExecutor = new ThreadPoolExecutor(
                PULL_SIZE,
                MAX_PULL_SIZE,
                KEEP_ALIVE,
                UNIT,
                QUEUE
        );
    }

    public static ThreadExecutorImpl getExcecutor() {
        if (threadExecutorImpl == null) {
            threadExecutorImpl = new ThreadExecutorImpl();
            threadExecutorImpl.createPool();
        }

        return threadExecutorImpl;
    }
}
