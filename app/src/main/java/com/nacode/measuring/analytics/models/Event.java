package com.nacode.measuring.analytics.models;

/**
 * Project Sign-Up.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/6/17.
 */
public class Event {

    private String eventCategory;
    private String eventAction;
    private String eventLabel;
    private double eventValue;

    public static Event newInstance() {
        return new Event();
    }

    public Event setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
        return this;
    }

    public Event setEventAction(String eventAction) {
        this.eventAction = eventAction;
        return this;
    }

    public Event setEventLabel(String eventLabel) {
        this.eventLabel = eventLabel;
        return this;
    }

    public Event setEventValue(double value) {
        this.eventValue = value;
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

    public double getEventValue() {
        return eventValue;
    }
}
