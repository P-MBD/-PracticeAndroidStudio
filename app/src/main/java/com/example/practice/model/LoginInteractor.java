package com.example.practice.model;

public interface LoginInteractor {


    interface OnLoginFinishedListener {
        public  void onUsernameError();
        public  void onPasswordError();
        public  void onSuccess();
    }


    public void login(String userName,String password,OnLoginFinishedListener onLoginFinishedListener);

}