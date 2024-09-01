package com.example.practice.model;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

public class LoginInteractorImpl implements LoginInteractor {

    private static final String TAG = "LoginInteractorImpl";

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        Log.d(TAG, "login: Started login process");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(username)) {
                    Log.d(TAG, "run: Username is empty");
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Log.d(TAG, "run: Password is empty");
                    listener.onPasswordError();
                    return;
                }
                Log.d(TAG, "run: Login successful");
                listener.onSuccess();
            }
        }, 2000); // Simulate delay for login process
    }
}