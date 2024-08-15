package com.example.practice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), getLifecycle()));

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            // تنظیم عنوان تب‌ها
            tab.setText("Tab " + (position + 1));
        }).attach();
    }

    private static class MyFragmentAdapter extends FragmentStateAdapter {

        public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // بازگرداندن Fragment مربوط به هر تب
            return new MyFragment();
        }

        @Override
        public int getItemCount() {
            return 3; // تعداد تب‌ها
        }
    }
}
