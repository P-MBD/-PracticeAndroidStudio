package com.example.practice.add;

import android.util.Log;

public class AddPresenterImpl implements AddPresenter, AddInteractor.OnAddFinishListener {
    private AddView addView;
    private AddInteractor addInteractor;
    private static final String TAG = "AddPresenterImpl";

    public AddPresenterImpl(AddView addView, AddInteractor addInteractor) {
        this.addView = addView;
        this.addInteractor = addInteractor;
    }

    @Override
    public void AddContact(String name, String family, String phone) {
        if (addView != null) {
            Log.d(TAG, "Adding contact: Name = " + name + ", Family = " + family + ", Phone = " + phone);
            addView.showProgress();
        }
        addInteractor.checkField(name, family, phone, this);
        addInteractor.insertContact(name, family, phone);
    }

    @Override
    public void onNameError() {
        if (addView != null) {
            Log.d(TAG, "Name error");
            addView.setNameError();
            addView.hideProgress();
        }
    }

    @Override
    public void onFamilyError() {
        if (addView != null) {
            Log.d(TAG, "Family error");
            addView.setFamilyError();
            addView.hideProgress();
        }
    }

    @Override
    public void onPhoneError() {
        if (addView != null) {
            Log.d(TAG, "Phone error");
            addView.setPhoneError();
            addView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (addView != null) {
            Log.d(TAG, "Contact added successfully");
            addView.navigateToHome();
            addView.hideProgress();
        }
    }
}
