package com.example.practice.presenter;


import android.util.Log;

import com.example.practice.model.LoginInteractor;
import com.example.practice.model.LoginInteractorImpl;
import com.example.practice.view.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private static final String TAG = "LoginPresenterImpl";

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        Log.d(TAG, "LoginPresenterImpl: Presenter created");
    }

    @Override
    public void validateCredentials(String username, String password) {
        Log.d(TAG, "validateCredentials: Validating credentials");
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError() {
        Log.d(TAG, "onUsernameError: Username error callback received");
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        Log.d(TAG, "onPasswordError: Password error callback received");
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        Log.d(TAG, "onSuccess: Login success callback received");
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}