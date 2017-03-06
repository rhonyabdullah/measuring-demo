package com.nacode.measuring.helpers;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Project Sign-Up.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/6/17.
 * for PT. Sumber Trijaya Lestari.
 */
public class Utils {

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidNamePattern(String name) {
        return !TextUtils.isEmpty(name) && name.matches("[a-zA-Z\\s]*");
    }

    public static boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password) && password.length() > 5;
    }

}
