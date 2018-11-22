package com.example.imu.golpo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Imu on 26-Apr-16.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle FirstThread) {
        super.onCreate(FirstThread);
        setContentView(R.layout.splash);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openMainActivity;
                    openMainActivity = new Intent("com.example.imu.golpo.MAINACTIVITY");
                    startActivity(openMainActivity);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}