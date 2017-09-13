package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.View;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.R;

public class GeneralPortal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
    private MediaPlayer mp;


    ///////////////
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Hi there!");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    ////////////////

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            displayRobotGameNotif();
            noitfyNotif();
        } else {
            super.onBackPressed();
        }
    }

    //TODO: Add this if we want to add a settings button to the top right side of the toolbar
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Scoreboard) {
            Intent t = new Intent(getApplicationContext(), Scoreboard.class);
            startActivity(t);
        } else if (id == R.id.nav_map) {
            Intent m = new Intent(getApplicationContext(), Map.class);
            startActivity(m);
        } else if (id == R.id.nav_Game_Schedule) {
            Intent g = new Intent(getApplicationContext(), GameSchedule.class);
            startActivity(g);

        } else if (id == R.id.nav_Judging_Schedule) {

        } else if(id == R.id.nav_Scorecalculator){

        }else if(id == R.id.nav_Exit){
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
            System.exit(0);
        }else if(id == R.id.nav_Logout){
            Intent d = new Intent(getApplicationContext(), TeamLogin.class);
            startActivity(d);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //TODO: Call this method in an other class when robot and judge schedule is setup
    private void displayRobotGameNotif(){



        mBuilder.setSmallIcon(R.drawable.clockicon);

        mBuilder.setContentTitle("ROBOT GAME");

        mBuilder.setContentText("RED Alliance in 5 min : Board 2");

        Intent t = new Intent(getApplicationContext(), Map.class);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, t, 0);

        mBuilder.setContentIntent(resultPendingIntent);



    }

    private void noitfyNotif(){

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

        Thread th = new Thread();
        try {
            th.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
