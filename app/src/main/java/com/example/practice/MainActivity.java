package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.practice.model.ModelCallBack;
import com.example.practice.presentor.MainPresenterImpl;
import com.example.practice.presentor.MainPresentor;

public class MainActivity extends AppCompatActivity implements LoginView {
EditText username, password;
ProgressBar progress;
Button button;
MainPresentor mainPresentor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.password);
        password = (EditText) findViewById(R.id.username);
        progress = (ProgressBar) findViewById(R.id.progress);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainPresentor.login(username.getText().toString(),password.getText().toString());

            }
        });
        mainPresentor = new MainPresenterImpl(this, new ModelCallBack());

        // اطمینان از اینکه ID درست استفاده شده است
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        Toast.makeText(getApplicationContext(),"Error userName",Toast.LENGTH_LONG);
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(getApplicationContext(),"Error Passowrd",Toast.LENGTH_LONG);
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_LONG);
    }
}
