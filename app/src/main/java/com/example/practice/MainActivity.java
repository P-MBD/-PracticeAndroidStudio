package com.example.practice;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.practice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // برای فیلتر کردن لاگ‌ها

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // تنظیم Data Binding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // ساخت یک User نمونه و اتصال آن به layout
        User user = new User("John", "Doe");
        binding.setUser(user);

        // ثبت یک پیام لاگ در زمان ایجاد Activity
        Log.d(TAG, "Activity Created. User's first name: " + user.firstName);

        // ثبت یک پیام لاگ در هنگام کلیک روی یک دکمه (در صورت وجود)
        binding.someButton.setOnClickListener(v -> {
            Log.d(TAG, "Button clicked. Current User's last name: " + user.lastName);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity Destroyed");
    }
}
