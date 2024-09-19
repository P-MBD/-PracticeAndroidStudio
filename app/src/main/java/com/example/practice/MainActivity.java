package com.example.practice;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practice.Database.DatabaseAssets;
import com.example.practice.Fragment.StationsFragment;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    DatabaseAssets mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydatabase = new DatabaseAssets(getApplicationContext());

        try {
            mydatabase.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mydatabase.openDataBase();


        if (savedInstanceState == null)
        {

            getSupportFragmentManager().beginTransaction().add(R.id.container,new StationsFragment()).commit();


        }

        }

    }


