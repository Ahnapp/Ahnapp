package com.example.hoyoung.ahnapp01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Ahnapp_start extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ahnapp_start);

        ImageView image01 = (ImageView) findViewById(R.id.imageView01);

        Animation anim00 = AnimationUtils.loadAnimation(this, R.anim.fadeout);
        image01.startAnimation(anim00);

        Handler mhandler = new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit); //activity ��ȯ �� anim
                Intent i = new Intent(Ahnapp_start.this, Ahnapp_Intro.class);
                startActivity(i);
                finish();
            }
        }, 3000); //3���� �ڵ� ȭ�� ��ȯ
    }
}
