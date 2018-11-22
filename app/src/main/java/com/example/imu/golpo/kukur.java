package com.example.imu.golpo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class kukur extends AppCompatActivity {

    MediaPlayer kukurPlayer;

    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kukur);

        Button stateButton = (Button) findViewById(R.id.state);
        Button stopButton = (Button) findViewById(R.id.stop);

        kukurPlayer = MediaPlayer.create(kukur.this,R.raw.kukur);

        stateButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(flag){
                    kukurPlayer = MediaPlayer.create(kukur.this,R.raw.kukur);
                    flag = false;
                }

                playPause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true;

                kukurPlayer.stop();
            }
        });
    }

    public  void playPause()
    {
        if(kukurPlayer.isPlaying()){
            kukurPlayer.pause();


        }
        else {
            kukurPlayer.start();

        }
    }

    public void home(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        kukurPlayer.release();
        finish();
    }


}
