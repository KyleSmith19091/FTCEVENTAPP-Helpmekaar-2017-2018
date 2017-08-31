package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Controller.DBTeamIDs;
import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Model.TeamQualities;
import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.R;

import java.util.ArrayList;

public class Scoreboard extends AppCompatActivity {

    ListView lv;
    DBTeamIDs db;
    ArrayList<TeamQualities> items;
    TeamQualities tm = new TeamQualities();
    Scoreboard_Teamqualities_Adapter TeamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        allocateVars();

        db.getWritableDatabase();

        PopulateListView();
    }

    private void allocateVars(){

        lv =(ListView) findViewById(R.id.listView);
        db = new DBTeamIDs(this);
        items = db.getData();
        TeamAdapter= new Scoreboard_Teamqualities_Adapter(this, items);

    }

    private void PopulateListView(){
        items = db.getData();
        TeamAdapter = new Scoreboard_Teamqualities_Adapter(this, items);
        lv.setAdapter(TeamAdapter);
    }



    }

