package com.example.practice.add;

import com.example.practice.data.ContactModel;

public interface AddInteractor {
    interface OnAddFinishListener {
        void onNameError();
        void onFamilyError();
        void onPhoneError();
        void onSuccess();
    }

    void checkField(String name, String family, String phone, OnAddFinishListener onAddFinishListener);

    // اضافه کردن متد insertContact
    ContactModel insertContact(String name, String family, String phone);
}
