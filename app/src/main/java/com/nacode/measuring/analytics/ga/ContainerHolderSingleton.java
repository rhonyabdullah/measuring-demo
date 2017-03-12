package com.nacode.measuring.analytics.ga;

import com.google.android.gms.tagmanager.ContainerHolder;

/**
 * Project measuring-demo.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/12/17.
 */
public class ContainerHolderSingleton {

    private static ContainerHolder instance;

    private ContainerHolderSingleton() {
    }

    public static ContainerHolder getInstance() {
        return instance;
    }

    public static void setInstance(ContainerHolder containerHolder) {
        instance = containerHolder;
    }

}
