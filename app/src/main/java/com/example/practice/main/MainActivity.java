package com.example.practice.main;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practice.R;
import com.example.practice.adapter.ContactAdapter;
import com.example.practice.data.ContactModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    private MainPresenter mainPresenter;
    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d(TAG, "Initializing presenter...");
        mainPresenter = new MainPresenterImpl(this, new MainInteractorImpl());

        getContacts(); // دریافت و نمایش لیست مخاطبین
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called, refreshing contacts...");
        getContacts(); // به‌روزرسانی لیست مخاطبین هنگام بازگشت به صفحه
    }

    public void getContacts() {
        try {
            Log.d(TAG, "Getting contacts from presenter...");
            List<ContactModel> contactList = mainPresenter.showContacts();
            setItems(contactList);
        } catch (Exception e) {
            Log.e(TAG, "Error getting contacts", e);
        }
    }

    @Override
    public void setItems(List<ContactModel> contacts) {
        Log.d(TAG, "Setting items to RecyclerView with " + contacts.size() + " contacts.");
        contactAdapter = new ContactAdapter(contacts);
        recyclerView.setAdapter(contactAdapter);
    }
}
