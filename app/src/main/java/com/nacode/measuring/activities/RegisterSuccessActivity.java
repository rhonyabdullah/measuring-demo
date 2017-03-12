package com.nacode.measuring.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nacode.measuring.R;
import com.nacode.measuring.analytics.ga.TagManager;

/**
 * Project measuring-demo.
 * <p>
 * Created by Rhony Abdullah Siagian on 3/12/17.
 */
public class RegisterSuccessActivity extends BaseActivity {

    private static final String LOG_TAG = RegisterSuccessActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TagManager.logScreenName(getString(R.string.scr_register));
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_register_success;
    }

    @Override
    protected void viewsBinding() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_register_success:
//                todo, launch to home activity
                finish();
                break;
            default:
                Log.d(LOG_TAG, "non click action");
        }
    }
}
