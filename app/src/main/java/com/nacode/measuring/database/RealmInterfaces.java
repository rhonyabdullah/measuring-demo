package com.nacode.measuring.database;

/**
 * Project measuring-demo.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/13/17.
 */
public interface RealmInterfaces {
    void onSuccessTransaction();
    void onErrorTransaction(Throwable error);
}
