package com.nacode.measuring.analytics.ga;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tagmanager.DataLayer;
import com.nacode.measuring.Measuring;
import com.nacode.measuring.analytics.models.EventModel;

/**
 * Project Sign-Up.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/4/17.
 * for PT. Sumber Trijaya Lestari.
 */
public class TagManager extends GtmUtils {

    private static final String LOG_TAG = TagManager.class.getSimpleName();

    private static final String[] dataLayerTypes =
            {
                    GtmUtils.Variables.ecommerce,
                    GtmUtils.Variables.screenName,
                    GtmUtils.Variables.eventCategory,
                    GtmUtils.Variables.eventAction,
                    GtmUtils.Variables.eventLabel,
                    GtmUtils.Variables.eventValue
            };

    public static void logScreenName(@NonNull String screenName) {

        dataLayer().pushEvent(GtmUtils.Events.openScreen,
                DataLayer.mapOf
                        (
                                GtmUtils.Variables.screenName, screenName
                        ));

        Log.d(LOG_TAG, "logScreenName " + screenName);

        resetDataLayer();

    }

    public static void logEventSignUp(@NonNull EventModel eventModel) {

        dataLayer().pushEvent(Events.signedUp,
                DataLayer.mapOf(
                        Variables.eventCategory, eventModel.getEventCategory(),
                        Variables.eventAction, eventModel.getEventAction(),
                        Variables.eventLabel, eventModel.getEventLabel()
                ));

        Log.d(LOG_TAG, "logEventSignUp with action "+ eventModel.getEventAction());

        resetDataLayer();
    }

    private static void resetDataLayer() {
        for (String dataLayerType : dataLayerTypes) {
            dataLayer().push(DataLayer.mapOf(dataLayerType, DataLayer.OBJECT_NOT_PRESENT));
        }
    }

    private static DataLayer dataLayer() {
        return Measuring.getDataLayer();
    }

}
