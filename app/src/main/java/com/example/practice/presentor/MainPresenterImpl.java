package com.example.practice.presentor;

import android.util.Log;

import com.example.practice.model.LoginInteractor;
import com.example.practice.LoginView;

public class MainPresenterImpl  implements MainPresentor, LoginInteractor.OnLoginFinishedListener {
    private static final String TAG = "MainPresenterImpl"; // برای شناسایی لاگ‌ها
    LoginView loginView;
    LoginInteractor interactor;
    public  MainPresenterImpl(LoginView loginView, LoginInteractor loginInteractor){
        this.loginView = loginView;
        this.interactor = loginInteractor;
        Log.d(TAG, "MainPresenterImpl initialized");
    }
    @Override
    public void login(String user, String password) {
        Log.d(TAG, "Attempting to login with user: " + user);
        if(loginView!=null){
            loginView.showProgress();
        }


        interactor.login(user, password, this);
    }


    @Override
    public void onUsernameError() {
        Log.w(TAG, "Username error occurred");
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        Log.w(TAG, "Password error occurred");
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        Log.i(TAG, "Login successful");
        if (loginView != null) {
            loginView.hideProgress();
            loginView.navigateToHome();
        }
    }
}
