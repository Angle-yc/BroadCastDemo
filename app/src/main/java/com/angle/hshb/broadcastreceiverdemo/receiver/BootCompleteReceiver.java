package com.angle.hshb.broadcastreceiverdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.angle.hshb.broadcastreceiverdemo.MainActivity;

/**
 * 监听手机开机的广播
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    public static final String TAG = "BootCompleteReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"手机开机了，自启动中。。。");
        intent.setClass(context,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
