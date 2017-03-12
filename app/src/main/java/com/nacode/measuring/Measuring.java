package com.nacode.measuring;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;
import com.nacode.measuring.analytics.ga.ContainerHolderSingleton;

import java.util.concurrent.TimeUnit;

/**
 * Project Sign-Up.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/6/17.
 */
public class Measuring extends Application {

    private static final String LOG_TAG = Measuring.class.getSimpleName();

    private static DataLayer dataLayer;
    private static Measuring instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initTagManager(instance);
    }

    private static void initTagManager(Measuring instance) {
        // Set the dispatch period in seconds.
        GoogleAnalytics.getInstance(instance).setLocalDispatchPeriod(5);

        final TagManager tagManager = TagManager.getInstance(instance);
        tagManager.setVerboseLoggingEnabled(BuildConfig.DEBUG);
        tagManager.loadContainerPreferFresh(BuildConfig.GTM_ID, R.raw.gtm_default)
                .setResultCallback(new ResultCallback<ContainerHolder>() {
                    @Override
                    public void onResult(@NonNull ContainerHolder containerHolder) {

//                      if unsuccessfull just return and use container from disk
                        if (!containerHolder.getStatus().isSuccess()) {
                            Log.d(LOG_TAG, " Fail to load container holder !");
                            return;
                        }

//                        Now, save the container
                        ContainerHolderSingleton.setInstance(containerHolder);

                        ContainerHolderSingleton.getInstance().refresh();

                        dataLayer = tagManager.getDataLayer();

                    }
                }, 2, TimeUnit.SECONDS);

        dataLayer = tagManager.getDataLayer();
    }

    public static DataLayer getDataLayer() {
        if (dataLayer == null) {
            initTagManager(getInstance());
        }
        return dataLayer;
    }

    public static Measuring getInstance() {
        return instance;
    }
}
