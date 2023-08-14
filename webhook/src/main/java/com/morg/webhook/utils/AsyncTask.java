package com.morg.webhook.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncTask {

    private final Executor backgroundThread;
    private final Executor mainThread;

    public AsyncTask() {
        this.backgroundThread = Executors.newSingleThreadExecutor();
        this.mainThread = new MainThreadExecutor();
    }

    public Executor getBackgroundThread() {
        return backgroundThread;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private final Handler mainThreadHandler = new Handler(
                Looper.getMainLooper()
        );

        @Override
        public void execute(Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}

