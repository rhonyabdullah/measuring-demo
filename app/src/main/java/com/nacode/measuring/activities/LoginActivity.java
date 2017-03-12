package com.nacode.measuring.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.nacode.measuring.R;
import com.nacode.measuring.analytics.ga.TagManager;
import com.nacode.measuring.analytics.models.Event;
import com.nacode.measuring.helpers.Utils;

public class LoginActivity extends BaseActivity {

    private static final String LOG_TAG = LoginActivity.class.getSimpleName();

//    region Views
    EditText username, password;
    RelativeLayout activityLogin;
//    endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TagManager.logScreenName(getString(R.string.scr_log_in));
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void viewsBinding() {
        activityLogin = (RelativeLayout) findViewById(R.id.activity_login);
        username = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_login:
                login();
                break;
            default:
                Log.d(LOG_TAG, "non click action");

        }
    }

    private void login() {
        String usernameText = username.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        if (usernameText.isEmpty() || passwordText.isEmpty()) {
            showSnackBar(activityLogin, getString(R.string.required_fields));
            return;
        }

        if (!Utils.isValidNamePattern(usernameText)){
            showSnackBar(username, getString(R.string.error_username));
            return;
        }

        if (!Utils.isValidPassword(passwordText)) {
            showSnackBar(password, getString(R.string.error_password));
            return;
        }


        TagManager.logEventLogin(Event.newInstance()
                .setEventCategory("Interactions")
                .setEventAction("Authentications")
                .setEventLabel("Login")
                .setEventValue(1));


        showSnackBar(activityLogin, "Login Successfully !");
//        WelcomeActivity.instance.finish();
//        finish();

    }
}
