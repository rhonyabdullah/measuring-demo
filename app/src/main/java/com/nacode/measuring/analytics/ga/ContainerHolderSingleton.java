package com.nacode.measuring.analytics.ga;

import com.google.android.gms.tagmanager.ContainerHolder;

/**
 * Project Sign-Up.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/6/17.
 * for PT. Sumber Trijaya Lestari.
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
