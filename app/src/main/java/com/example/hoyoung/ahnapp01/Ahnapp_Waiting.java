package com.example.hoyoung.ahnapp01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class Ahnapp_Waiting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ahnapp_waiting);
    }
}
