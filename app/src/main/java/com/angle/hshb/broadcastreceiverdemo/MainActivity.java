package com.angle.hshb.broadcastreceiverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.angle.hshb.broadcastreceiverdemo.receiver.MyBroadcastReceiver;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver receiver;
    private IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        dynamicRegisterReceiver();
    }

    /**
     * 动态注册广播
     * 动态注册的广播必须要手动的去销毁
     */
    private void dynamicRegisterReceiver() {
        intentFilter = new IntentFilter();
        receiver = new MyBroadcastReceiver();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver !=null){
            unregisterReceiver(receiver);
        }
    }

    public void sendBroadCast(View view) {
        Intent intent = new Intent("com.com.angle.hshb.MY_BROADCAST");
        intent.putExtra("tag","static");
        sendBroadcast(intent);
    }
}
