package com.example.hoyoung.ahnapp01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class Ahnapp_Intro extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ahnapp_intro);

        ImageView image02 = (ImageView) findViewById(R.id.imageView02);
//        ImageView image03 = (ImageView) findViewById(R.id.imageView03);
//        ImageView image04 = (ImageView) findViewById(R.id.imageView04);

        Animation anim01 = AnimationUtils.loadAnimation(this, R.anim.fade);
        image02.startAnimation(anim01);
//        image03.startAnimation(anim01);
//        image04.startAnimation(anim01);



        Handler mhandler = new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit); //activity 전환 시 anim
                Intent i = new Intent(Ahnapp_Intro.this, Ahnapp_Waiting.class);
                startActivity(i);
                finish();
            }
        }, 5000); //3초후 자동 화면 전환
    }


}

