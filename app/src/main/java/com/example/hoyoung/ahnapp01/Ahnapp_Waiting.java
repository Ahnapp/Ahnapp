package com.example.hoyoung.ahnapp01;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;


public class Ahnapp_Waiting extends Activity {

    //Debugging
    private static final String TAG = "BluetoothService";

    //Intent request code
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;


    private Activity mActivity;
    protected BluetoothAdapter btAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ahnapp_waiting);

        //BluetoothAdapter 얻기
        btAdapter = BluetoothAdapter.getDefaultAdapter();

        if(getDeviceState()){

            Toast toast = Toast.makeText(this,"Bluetooth가 지원되는 기기 입니당",Toast.LENGTH_SHORT);
            toast.show();
            enableBluetooth();

        } else{

            Toast toast = Toast.makeText(this,"Bluetooth가 지원되지 않는 기기 임당",Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }


    }


    //Bluetooth가 사용가능한 기기인지 판단
    public boolean getDeviceState(){
        Log.i(TAG, "Check the Bluetooth support");

        if(btAdapter == null){
            return false;
        } else{
            Log.d(TAG, "Bluetooth is available");

            return true;
        }
    }

    public void enableBluetooth(){
        Log.i(TAG, "Check the enabled Bluetooth");

        //.isEnable()을 통하여 현재 bluetooth가 on인지 확인
        if(btAdapter.isEnabled()){
            //기기의 블루투스 상태가 on인 경우
            Toast toast = Toast.makeText(this,"성공성공", Toast.LENGTH_SHORT);
            toast.show();
            Log.d(TAG, "Bluetooth Enable Now");

        } else{
            //기기의 블루투스 상태가 off인 경우 - 개선사항
            Toast toast = Toast.makeText(this,"블루투스 off된 경우", Toast.LENGTH_SHORT);
            toast.show();

            Log.d(TAG, "Bluetooth Enable Request");

//            btAdapter.enable(); //블루투스 온
//            Toast toast2 = Toast.makeText(this,"블루투스 on시켰습니다!", Toast.LENGTH_SHORT);
//            toast2.show();



            Handler mhandler = new Handler();
            mhandler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    btAdapter.enable(); //블루투스 온

                    Toast toast2 = Toast.makeText(Ahnapp_Waiting.this, "블루투스 on시켰습니다!", Toast.LENGTH_SHORT);
                    toast2.show();

                }
            }, 15000); //15초후 bluetooth on!




//            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(i,REQUEST_ENABLE_BT);
        }
    }
}


