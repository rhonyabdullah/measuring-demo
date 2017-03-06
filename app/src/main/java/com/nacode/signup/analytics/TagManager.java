package com.nacode.signup.analytics;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Project Sign-Up.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/4/17.
 * for PT. Sumber Trijaya Lestari.
 */
public class TagManager {

    public static final String LOG_TAG = TagManager.class.getSimpleName();

    private static final String[] dataLayerTypes =
            {
                    GtmUtils.ecommerce,
                    GtmUtils.screenName,
                    GtmUtils.eventCategory,
                    GtmUtils.eventAction,
                    GtmUtils.eventLabel,
                    GtmUtils.eventValue
            };

    public static void logScreenName(@NonNull String screenName) {



        Log.d(LOG_TAG, "logScreenName "+screenName);
    }

//    private void resetDataLayer() {
//        for (String dataLayerType : dataLayerTypes) {
//            dataLayer().push(DataLayer.mapOf(dataLayerType, DataLayer.OBJECT_NOT_PRESENT));
//        }
//    }

    private static class GtmUtils {
        private static final String ecommerce = "ecommerce";
        private static final String screenName = "screenName";
        private static final String eventCategory = "eventCategory";
        private static final String eventAction = "eventAction";
        private static final String eventLabel = "eventLabel";
        private static final String eventValue = "eventValue";


    }

}
