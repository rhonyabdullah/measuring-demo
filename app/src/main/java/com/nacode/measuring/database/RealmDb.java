package com.nacode.measuring.database;

import android.support.annotation.NonNull;

import com.nacode.measuring.database.models.UserDbReg;
import com.nacode.measuring.models.User;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Project measuring-demo.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/13/17.
 */
public class RealmDb {

    public static RealmAsyncTask saveRegisteredUser(@NonNull final User user, @NonNull final RealmInterfaces interfaces) {

        return realm().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                UserDbReg userReg = realm.createObject(UserDbReg.class);
                userReg.setEmail(user.getEmail());
                userReg.setUsername(user.getUsername());
                userReg.setPassword(user.getPassword());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm().close();
                interfaces.onSuccessTransaction();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                interfaces.onErrorTransaction(error);
            }
        });

    }

    public static RealmResults<UserDbReg> getRegisteredUsers(RealmChangeListener<RealmResults<UserDbReg>> callback) {

        RealmResults<UserDbReg> result = realm().where(UserDbReg.class).findAllAsync();
        result.addChangeListener(callback);

        return result;
    }

    private static Realm realm() {
        return Realm.getDefaultInstance();
    }

}
