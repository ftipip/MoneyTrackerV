package com.example.ftipip.moneytrackerv;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by ftipip on 11.09.2015.
 */
public class MoneyTrackerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
