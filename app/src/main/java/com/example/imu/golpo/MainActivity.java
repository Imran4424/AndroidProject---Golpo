package com.example.imu.golpo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendKukur(View view) {
        Intent intent = new Intent(this,kukur.class);
        startActivity(intent);
    }

    public void sendBang(View view) {
        Intent intent = new Intent(this,Bang.class);
        startActivity(intent);
    }

    public void sendJele(View view) {
        Intent intent = new Intent(this,Jele.class);
        startActivity(intent);
    }
}
