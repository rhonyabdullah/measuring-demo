package com.nacode.measuring.activities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nacode.measuring.R;
import com.nacode.measuring.analytics.ga.TagManager;
import com.nacode.measuring.analytics.models.Event;
import com.nacode.measuring.helpers.Easing;
import com.nacode.measuring.helpers.Utils;

public class SignUpActivity extends BaseActivity {

    public static final String LOG_TAG = SignUpActivity.class.getSimpleName();

//    region Views
    EditText username, email, password;
    ImageView iv_back;
    LinearLayout ll_button, ll_bottom;
    RelativeLayout activitySignUp;
//    endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ease(ll_button, 1000, 700);
        ease(ll_bottom, 1200, 1100);

        TagManager.logScreenName(getString(R.string.scr_sign_up));

    }

    @Override
    protected int setContentView() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void viewsBinding() {
        username = (EditText) findViewById(R.id.et_username);
        email = (EditText) findViewById(R.id.et_email);
        password= (EditText) findViewById(R.id.et_password);
        ll_button = (LinearLayout) findViewById(R.id.ll_button);
        ll_bottom = (LinearLayout) findViewById(R.id.ll_bottom);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        activitySignUp = (RelativeLayout) findViewById(R.id.activity_sign_up);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_sign_up:
                signUp();
                break;
            default:
                Log.d(LOG_TAG, "non click action");
        }
    }

    private static void ease(final View view, int easeDuration, int animatorDuration) {
        Easing easing = new Easing(easeDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        float fromY = 600;
        float toY = view.getTop();
        ValueAnimator valueAnimatorY = ValueAnimator.ofFloat(fromY,toY);

        valueAnimatorY.setEvaluator(easing);

        valueAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationY((float) animation.getAnimatedValue());
            }
        });

        animatorSet.playTogether(valueAnimatorY);
        animatorSet.setDuration(animatorDuration);
        animatorSet.start();
    }

    private void signUp() {

        String emailText = email.getText().toString().trim();
        String usernameText = username.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        if (usernameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()) {
            showSnackBar(activitySignUp, getString(R.string.required_fields));
            return;
        }

        if (!Utils.isValidNamePattern(usernameText)) {
            showSnackBar(email, getString(R.string.error_username));
            return;
        }

        if (!Utils.isValidEmail(emailText)) {
            showSnackBar(email, getString(R.string.error_email));
            return;
        }

        if (!Utils.isValidPassword(passwordText)) {
            showSnackBar(password, getString(R.string.error_email));
            return;
        }

        TagManager.logEventSignedUp(Event.newInstance()
                .setEventCategory("Interactions")
                .setEventAction("Authentications")
                .setEventLabel("Sign_Up")
                .setEventValue(1));


        startActivity(new Intent(this, RegisterSuccessActivity.class));
        WelcomeActivity.instance.finish();
        finish();

    }

}
