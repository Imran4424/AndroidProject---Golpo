package com.example.imu.golpo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Bang extends AppCompatActivity {


    MediaPlayer bangPlayer;
    
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang);

        Button stateButton = (Button) findViewById(R.id.state);
        Button stopButton = (Button) findViewById(R.id.stop);

        bangPlayer = MediaPlayer.create(Bang.this, R.raw.bang);

        stateButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(flag){
                    bangPlayer = MediaPlayer.create(Bang.this, R.raw.bang);
                    flag = false;
                }


                playPause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flag = true;
                bangPlayer.stop();

            }
        });
    }

    public  void playPause()
    {
        if(bangPlayer.isPlaying()){
            bangPlayer.pause();


        }
        else {
            bangPlayer.start();

        }
    }

    public void home(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bangPlayer.release();
        finish();
    }


}