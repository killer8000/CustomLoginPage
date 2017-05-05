package com.example.ndh.myapplication2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mUserNameTip;
    private TextView mPwdTip;
    private EditText mPwd;
    private EditText mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserName = (EditText) findViewById(R.id.user_name);
        mPwd = (EditText) findViewById(R.id.pwd);
        mUserNameTip = (TextView) findViewById(R.id.tip_user_name);
        mPwdTip = (TextView) findViewById(R.id.tip_pwd);
        mUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    transY(mUserNameTip, 0);

                } else {

                    transY(mUserNameTip, getResources().getDimension(R.dimen.height_login)/2);
                }
            }
        });
        mPwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    transY(mPwdTip, 0);
                } else {

                    transY(mPwdTip, getResources().getDimension(R.dimen.height_login)/2);
                }
            }
        });

    }

    private void transY(final View v, final float trans) {
        float transY = v.getTranslationY();
        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "translationY", transY, trans);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

                switch (v.getId()) {
                    case R.id.tip_user_name:
                        if (trans == 0) {
                            mUserNameTip.setVisibility(View.VISIBLE);
                            mUserName.setHint("");
                        } else {
                        }
                        break;
                    case R.id.tip_pwd:
                        if (trans == 0) {
                            mPwdTip.setVisibility(View.VISIBLE);
                            mPwd.setHint("");
                        } else {
                        }
                        break;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                switch (v.getId()) {
                    case R.id.tip_user_name:
                        if (trans == 0) {
                        } else {
                            mUserNameTip.setVisibility(View.GONE);
                            mUserName.setHint(mUserNameTip.getText());
                        }
                        break;
                    case R.id.tip_pwd:
                        if (trans == 0) {
                        } else {
                            mPwdTip.setVisibility(View.GONE);
                            mPwd.setHint(mPwdTip.getText());
                        }
                        break;
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setDuration(200).start();
    }

}
