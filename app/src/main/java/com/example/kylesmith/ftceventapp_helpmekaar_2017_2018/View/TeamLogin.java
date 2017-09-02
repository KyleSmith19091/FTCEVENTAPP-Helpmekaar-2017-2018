package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Controller.DBTeamIDs;
import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.R;

public class TeamLogin extends AppCompatActivity {

    //Vars
    EditText etxtTeamNumberLogin;
    Button btnLoginDone;

    //Objects
    DBTeamIDs dbTeamIDs;
    MediaPlayer accessGranted;
    MediaPlayer accessDenied;

    ///////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_login);
        allocateVars();
        setCustomEditableTextViewProperties();
        loginButtonPressed();

    }
    /////////////////

    //init vars
    private void allocateVars(){

        etxtTeamNumberLogin = (EditText) findViewById(R.id.etxtTeamNumberLogin);
        btnLoginDone = (Button) findViewById(R.id.btnLoginDone);
        dbTeamIDs = new DBTeamIDs(this);
        accessGranted = MediaPlayer.create(this, R.raw.access_granted);
        accessDenied = MediaPlayer.create(this, R.raw.access_denied);

    }

    //Set custom properties for the editable textview
    private void setCustomEditableTextViewProperties(){

        etxtTeamNumberLogin.setText("Enter team number here");
        etxtTeamNumberLogin.setSelection(0, etxtTeamNumberLogin.getText().length());
        etxtTeamNumberLogin.setTextIsSelectable(true);

    }

    //Click listener for the login button to check if team number is registered in the database //Data will hopefully be by FIRST

    private void loginButtonPressed(){

        btnLoginDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if(dbTeamIDs.getTeamNumber().contains(etxtTeamNumberLogin.getText().toString() )){

                        accessGranted.start();
                        Intent g = new Intent(TeamLogin.this, GeneralPortal.class);
                        startActivity(g);

                    }else{

                        accessDenied.start();
                        Toast.makeText(TeamLogin.this, "TEAM NUMBER NOT FOUND!", Toast.LENGTH_SHORT).show();
                        etxtTeamNumberLogin.setText("Enter team number here");
                        etxtTeamNumberLogin.setSelection(0, etxtTeamNumberLogin.getText().length());

                    }

            }
        });//End of onclick listener for the login button

    }//End of login button pressed method

}//End of class
