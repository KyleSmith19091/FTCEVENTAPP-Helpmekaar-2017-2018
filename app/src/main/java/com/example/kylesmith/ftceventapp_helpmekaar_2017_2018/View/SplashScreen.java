package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.R;

public class SplashScreen extends AppCompatActivity {

    //Objects
    Thread thread = new Thread();


    /////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent t = new Intent(SplashScreen.this, TeamLogin.class);
        try {
            thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(t);
            }
    ////////////////////
    }//End of the class

