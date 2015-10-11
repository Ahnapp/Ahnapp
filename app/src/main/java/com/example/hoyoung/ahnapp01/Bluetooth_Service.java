package com.example.hoyoung.ahnapp01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.Toast;


public class Bluetooth_Service extends Ahnapp_Waiting {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ahnapp_bluetooth);



        Handler mhandler = new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                btAdapter.enable(); //블루투스 온

                Toast toast = Toast.makeText(Bluetooth_Service.this, "블루투스 온!", Toast.LENGTH_SHORT);
                toast.show();

                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit); //activity 전환 시 anim
                Intent i = new Intent(Bluetooth_Service.this , Ahnapp_Waiting.class);
                i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP | i.FLAG_ACTIVITY_SINGLE_TOP); //stack 제거
                startActivity(i);
                finish();

            }
        }, 15000); //15초후 자동 화면 전환

    }
}


