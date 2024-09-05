package com.example.practice.add;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.practice.databinding.ActivityAddBinding;
import com.example.practice.main.MainActivity;

public class AddActivity extends AppCompatActivity implements AddView {

    private ActivityAddBinding binding;
    private AddPresenter addPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // مقداردهی ViewBinding
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // مقداردهی AddPresenterImpl با استفاده از سازنده صحیح
        addPresenter = new AddPresenterImpl(this, new AddInteractorImpl(this));

        // تنظیم کلیک روی دکمه Save
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.etName.getText().toString();
                String family = binding.etFamily.getText().toString();
                String phone = binding.etPhone.getText().toString();

                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(family) && !TextUtils.isEmpty(phone)) {
                    addPresenter.AddContact(name, family, phone);
                } else {
                    Toast.makeText(AddActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setNameError() {
        Toast.makeText(getApplicationContext(), "لطفا نام را وارد کنید", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPhoneError() {
        Toast.makeText(getApplicationContext(), "لطفا شماره تلفن را وارد کنید", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setFamilyError() {
        Toast.makeText(getApplicationContext(), "لطفا نام خانوادگی را وارد کنید", Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(getApplicationContext(), "مشخصات شما با موفقیت ثبت شد.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
