package com.nacode.signup.activities;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nacode.signup.R;
import com.nacode.signup.utils.Easing;

public class SignUp extends BaseActivity {

    public static final String LOG_TAG = SignUp.class.getSimpleName();

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

}
