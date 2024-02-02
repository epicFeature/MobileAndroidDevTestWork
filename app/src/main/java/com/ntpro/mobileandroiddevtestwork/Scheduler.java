package com.ntpro.mobileandroiddevtestwork;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class Scheduler {
    private final Handler handler = new Handler(Looper.getMainLooper());
    public Scheduler() {}

    public void schedule (Runnable runnable) {
        Log.d("schedule", "started");
        handler.postDelayed(runnable, 3000);
    }

    public void scheduleCancel (Runnable runnable) {
        Log.d("schedule", "canceled");
        handler.removeCallbacksAndMessages(null);
    }

}
