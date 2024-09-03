package com.example.practice;

import android.util.Log;

public class User {

    private static final String TAG = "User";

    public String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        Log.d(TAG, "User created: " + firstName + " " + lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        Log.d(TAG, "First name set to: " + firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        Log.d(TAG, "Last name set to: " + lastName);
    }
}
