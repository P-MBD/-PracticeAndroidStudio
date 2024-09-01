package com.example.practice.view;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void navigateToHome();
}