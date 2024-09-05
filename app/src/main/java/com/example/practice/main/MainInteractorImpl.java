package com.example.practice.main;

import android.util.Log;
import com.example.practice.data.ContactModel;
import com.orm.query.Select;
import java.util.List;

public class MainInteractorImpl implements MainInteractor {

    private static final String TAG = "MainInteractorImpl";

    public List<ContactModel> showContact() {
        Log.d(TAG, "Fetching contacts from the database...");
        List<ContactModel> contactList = Select.from(ContactModel.class).list();
        Log.d(TAG, "Fetched " + contactList.size() + " contacts from the database.");
        return contactList;
    }

    @Override
    public void showItems(OnMainFinishedListener onMainFinishedListener) {
        Log.d(TAG, "showItems called");
        onMainFinishedListener.onSuccess();
    }
}
