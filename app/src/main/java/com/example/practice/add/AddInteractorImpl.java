package com.example.practice.add;

import android.content.Context;
import android.util.Log;
import com.example.practice.data.ContactModel;

public class AddInteractorImpl implements AddInteractor {
    private Context context;
    private static final String TAG = "AddInteractorImpl";

    public AddInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public ContactModel insertContact(String name, String family, String phone) {
        Log.d(TAG, "Inserting contact: Name = " + name + ", Family = " + family + ", Phone = " + phone);
        ContactModel contactModel = new ContactModel(name, family, phone);
        contactModel.save();
        Log.d(TAG, "Contact inserted with ID: " + contactModel.getId());
        return contactModel;
    }

    @Override
    public void checkField(String name, String family, String phone, OnAddFinishListener onAddFinishListener) {
        if (name.length() <= 0) {
            Log.d(TAG, "Name is empty");
            onAddFinishListener.onNameError();
        } else if (family.length() <= 0) {
            Log.d(TAG, "Family is empty");
            onAddFinishListener.onFamilyError();
        } else if (phone.length() <= 0) {
            Log.d(TAG, "Phone is empty");
            onAddFinishListener.onPhoneError();
        } else {
            Log.d(TAG, "All fields are valid");
            onAddFinishListener.onSuccess();
        }
    }
}
