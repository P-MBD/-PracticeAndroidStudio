package com.example.practice.main;

import com.example.practice.data.ContactModel;
import java.util.List;

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnMainFinishedListener {
    private MainView mainView;
    private MainInteractorImpl interactor;
    private List<ContactModel> contactList;

    public MainPresenterImpl(MainView mainView, MainInteractorImpl interactor) {
        this.mainView = mainView;
        this.interactor = interactor;
    }

    @Override
    public List<ContactModel> showContacts() {
        contactList = interactor.showContact();
        return contactList;
    }

    @Override
    public void onSuccess() {
        if (mainView != null) {
            mainView.setItems(contactList);
        }
    }
}
