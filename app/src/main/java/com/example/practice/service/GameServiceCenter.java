package com.example.practice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.example.practice.IGameService;

public class GameServiceCenter {

    public  void init(Context context,String packageName, LauncherService luncherService){
        Intent intent = new Intent("com.example.practice");
        intent.setPackage(packageName);
        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder iBinder) {
                luncherService.onResult(IGameService.Stub.asInterface( iBinder));
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                luncherService.onFail("fail");
            }
        };
        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }
}
