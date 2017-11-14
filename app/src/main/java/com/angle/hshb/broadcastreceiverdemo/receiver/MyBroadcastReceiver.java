package com.angle.hshb.broadcastreceiverdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * 练习广播
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String tag = intent.getStringExtra("tag");
        if ("static".equals(tag)){
            Log.i(TAG,"静态广播发送成功");
            return;
        }
        Log.i(TAG,"network changes");
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()){
            Log.i(TAG,"网络良好");
        }else {
            Log.i(TAG,"当前没有网络");
        }
    }
}
