package com.example.practice.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.practice.R;
import com.example.practice.presenter.LoginPresenter;
import com.example.practice.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d(TAG, "onCreate: Initializing views and presenter");

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        progressBar = findViewById(R.id.progressBar);

        loginPresenter = new LoginPresenterImpl(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Login button clicked");
                loginPresenter.validateCredentials(editTextUsername.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        Log.d(TAG, "showProgress: Showing progress bar");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        Log.d(TAG, "hideProgress: Hiding progress bar");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        Log.d(TAG, "setUsernameError: Showing username error");
        editTextUsername.setError("Username is required");
    }

    @Override
    public void setPasswordError() {
        Log.d(TAG, "setPasswordError: Showing password error");
        editTextPassword.setError("Password is required");
    }

    @Override
    public void navigateToHome() {
        Log.d(TAG, "navigateToHome: Navigating to home screen");
        // Intent logic to navigate to the next screen (Home screen)
    }
}