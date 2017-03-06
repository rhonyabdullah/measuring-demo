package com.nacode.measuring.activities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nacode.measuring.R;
import com.nacode.measuring.analytics.ga.TagManager;
import com.nacode.measuring.analytics.models.EventModel;
import com.nacode.measuring.helpers.Easing;
import com.nacode.measuring.helpers.Utils;

public class SignUpActivity extends BaseActivity {

    public static final String LOG_TAG = SignUpActivity.class.getSimpleName();

//    region Views
    EditText username, email, password;
    ImageView iv_back;
    LinearLayout ll_button, ll_bottom;
//    endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ease(ll_button, 1000, 700);
        ease(ll_bottom, 1200, 1100);

        TagManager.logScreenName(getString(R.string.sign_up));

    }

    @Override
    protected int getLayout() {
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

        String emailText = email.getText().toString();
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();

        if (!Utils.isValidEmail(emailText)) {
            Snackbar.make(email, getString(R.string.error_email), Snackbar.LENGTH_SHORT).show();
            return;
        }

        if (!Utils.isValidNamePattern(usernameText)) {
            Snackbar.make(email, getString(R.string.error_username), Snackbar.LENGTH_SHORT).show();
            return;
        }

        if (!Utils.isValidPassword(passwordText)) {
            Snackbar.make(password, getString(R.string.error_email), Snackbar.LENGTH_LONG).show();
            return;
        }

        TagManager.logEventSignUp(EventModel.newInstance()
                .setEventCategory("Interactions")
                .setEventAction("Authentications")
                .setEventLabel("Sign_Up"));

    }

}
