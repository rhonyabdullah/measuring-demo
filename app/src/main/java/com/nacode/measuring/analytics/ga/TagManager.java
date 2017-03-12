package com.nacode.measuring.analytics.ga;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tagmanager.DataLayer;
import com.nacode.measuring.Measuring;
import com.nacode.measuring.analytics.models.Event;

/**
 * Project measuring-demo.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/12/17.
 */
public class TagManager extends GtmUtils {

    private static final String LOG_TAG = TagManager.class.getSimpleName();

    private static final String[] dataLayerTypes =
            {
                    Variables.ecommerce,
                    Variables.screenName,
                    Variables.eventCategory,
                    Variables.eventAction,
                    Variables.eventLabel,
                    Variables.eventValue
            };

    public static void logScreenName(@NonNull String screenName) {

        dataLayer().pushEvent(Events.openScreen,
                DataLayer.mapOf
                        (
                                Variables.screenName, screenName
                        ));

        Log.d(LOG_TAG, "logScreenName " + screenName);

        resetDataLayer();

    }

    public static void logEventSignedUp(@NonNull Event event) {

        dataLayer().pushEvent(Events.signedUp,
                DataLayer.mapOf(
                        Variables.eventCategory, event.getEventCategory(),
                        Variables.eventAction, event.getEventAction(),
                        Variables.eventLabel, event.getEventLabel(),
                        Variables.eventValue, event.getEventValue()
                ));

        Log.d(LOG_TAG, "logEventSignedUp with action "+ event.getEventAction());

        resetDataLayer();
    }

    public static void logEventLogin(@NonNull Event event) {
        dataLayer().pushEvent(Events.login,
                DataLayer.mapOf(
                        Variables.eventCategory, event.getEventCategory(),
                        Variables.eventAction, event.getEventAction(),
                        Variables.eventLabel, event.getEventLabel(),
                        Variables.eventValue, event.getEventValue()
                ));

        Log.d(LOG_TAG, "logEventLogin with action "+ event.getEventAction());

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
