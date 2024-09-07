package com.example.practice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.practice.IGameService;
import com.example.practice.IRequestCallback;

public class GameService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IGameService.Stub binder = new IGameService.Stub() {
        @Override
        public void newMatch(String params) throws RemoteException {
            Log.d("GameService", "newMatch: " + params);
        }

        @Override
        public void canAcceptMatch(String params, IRequestCallback callback) throws RemoteException {
            Log.d("GameService", "canAcceptMatch: " + params);
            // برای مثال، می‌توانیم نتیجه را به callback ارسال کنیم
            callback.onResult("Accepted");
        }

        @Override
        public void startApp(String params) throws RemoteException {
            Log.d("GameService", "startApp: " + params);
        }
    };
}
