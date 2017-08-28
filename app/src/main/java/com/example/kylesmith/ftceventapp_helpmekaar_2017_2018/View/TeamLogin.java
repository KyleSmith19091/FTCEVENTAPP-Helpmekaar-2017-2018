package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Controller.DBTeamIDs;
import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Model.TeamQualities;
import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.R;

import java.util.ArrayList;

public class TeamLogin extends AppCompatActivity {

    //Vars
    EditText etxtTeamNumberLogin;
    Button btnLoginDone;

    //Objects
    DBTeamIDs dbTeamIDs;

    ///////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_login);
        allocateVars();
        loginButtonPressed();

    }
    /////////////////

    //init vars
    private void allocateVars(){

        etxtTeamNumberLogin = (EditText) findViewById(R.id.etxtTeamNumberLogin);
        etxtTeamNumberLogin.setText("Enter team number here");
        etxtTeamNumberLogin.setSelection(0, etxtTeamNumberLogin.getText().length());
        btnLoginDone = (Button) findViewById(R.id.btnLoginDone);
        dbTeamIDs = new DBTeamIDs(this);

    }

    //Click listener for the login button to check if team number is registered in the database //Data will hopefully be by FIRST

    private void loginButtonPressed(){

        btnLoginDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if(dbTeamIDs.getTeamNumber().contains(etxtTeamNumberLogin.getText().toString() )){

                        //TODO: Change the activity this goes to
                        Intent g = new Intent(TeamLogin.this, SplashScreen.class);
                        startActivity(g);

                    }else{

                        Toast.makeText(TeamLogin.this, "Team not registered please ask an official FIRST employee about problem", Toast.LENGTH_SHORT).show();

                    }

            }
        });//End of onclick listener for the login button

    }


}//End of class
