package com.example.practice.main;

public interface MainInteractor {
    interface OnMainFinishedListener {
        void onSuccess();
    }

    void showItems(OnMainFinishedListener onMainFinishedListener);
}
