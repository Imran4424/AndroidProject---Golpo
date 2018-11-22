package com.example.imu.golpo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Jele extends AppCompatActivity {

    MediaPlayer jelePlayer;

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jele);

        Button stateButton = (Button) findViewById(R.id.state);
        Button stopButton = (Button) findViewById(R.id.stop);

        jelePlayer = MediaPlayer.create(Jele.this, R.raw.jele);


        stateButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(flag==0){
                    jelePlayer = MediaPlayer.create(Jele.this, R.raw.jele);
                    flag = 1;
                }


                playPause();

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag = 0;
                jelePlayer.stop();

            }
        });
    }

    public  void playPause()
    {
        if(jelePlayer.isPlaying()){
            jelePlayer.pause();


        }
        else {
            jelePlayer.start();

        }
    }

    public void home(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        jelePlayer.release();
        finish();
    }


}