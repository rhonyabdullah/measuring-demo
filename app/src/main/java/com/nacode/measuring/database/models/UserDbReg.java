package com.nacode.measuring.database.models;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Project measuring-demo.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/13/17.
 */
public class UserDbReg extends RealmObject {

    @Required
    private String email;

    @Required
    private String username;

    @Required
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
