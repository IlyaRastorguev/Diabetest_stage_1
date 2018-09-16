package com.diabetest.domain;

import android.os.Handler;
import android.os.Looper;

public class MainThreadImpl implements MainThread {

    private static MainThreadImpl mainThread;

    private Handler handler;

    private MainThreadImpl() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doPost(Runnable runnable) {
        handler.post(runnable);
    }

    public static MainThread getMainThread() {
        if (mainThread == null) {
            mainThread = new MainThreadImpl();
        }

        return mainThread;
    }

}
