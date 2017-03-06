package com.nacode.measuring.analytics.models;

/**
 * Project Sign-Up.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/6/17.
 * for PT. Sumber Trijaya Lestari.
 */
public class EventModel {

    private String eventCategory;
    private String eventAction;
    private String eventLabel;

    public static EventModel newInstance() {
        return new EventModel();
    }

    public EventModel setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
        return this;
    }

    public EventModel setEventAction(String eventAction) {
        this.eventAction = eventAction;
        return this;
    }

    public EventModel setEventLabel(String eventLabel) {
        this.eventLabel = eventLabel;
        return this;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public String getEventAction() {
        return eventAction;
    }

    public String getEventLabel() {
        return eventLabel;
    }
}
