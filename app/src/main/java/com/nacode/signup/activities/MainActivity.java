package com.nacode.signup.activities;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.nacode.signup.R;

public class MainActivity extends BaseActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void viewsBinding() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_up:
                startActivity(new Intent(this, SignUp.class));
                break;
            default:
                Log.d(LOG_TAG, "non click action");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
