package com.example.practice.model;

public class ModelCallBack implements LoginInteractor {
    @Override
    public void login(String userName, String password, OnLoginFinishedListener onLoginFinishedListener) {
            if(userName.length()<= 0){
                onLoginFinishedListener.onUsernameError();
            }else if(password.length()<= 0){
                onLoginFinishedListener.onPasswordError();
            }
            else {
                onLoginFinishedListener.onSuccess();
            }
    }
}
