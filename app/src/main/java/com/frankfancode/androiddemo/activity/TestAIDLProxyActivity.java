package com.frankfancode.androiddemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.frankfancode.androiddemo.R;
import com.frankfancode.androiddemo.service.IDemoService;

/**
 * Created by Frank on 2015/10/25.
 */
public class TestAIDLProxyActivity extends Activity implements View.OnClickListener {

    private IDemoService myService = null;
    private Button mButton1;
    private Button mButton2;
    private TextView textView;

    private ServiceConnection serviceConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder service) {
            // 获得服务对象
            myService = IDemoService.Stub.asInterface(service);
            mButton2.setEnabled(true);
        }

        public void onServiceDisconnected(ComponentName name) {
        }
    };

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button01:
                textView.setText(":-)");

                try {
                    // 绑定AIDL服务
                    bindService(new Intent("com.frankfancode.aidlserverdemo.IDemoService"),
                            serviceConnection, Context.BIND_AUTO_CREATE);
                }catch (Exception e){
                }
                break;
            case R.id.button02:
                try {
                    textView.setText(myService.getValue()); // 调用服务端的getValue方法
                } catch (Exception e) {
                }
                break;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aidl);
        mButton1 = (Button) findViewById(R.id.button01);
        mButton1.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button02);
        mButton2.setOnClickListener(this);
        mButton2.setEnabled(false);
        textView = (TextView) findViewById(R.id.mTextView01);

    }
}