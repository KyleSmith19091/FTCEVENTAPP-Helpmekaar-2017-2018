package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Model.TeamQualities;

import java.util.ArrayList;

/**
 * Created by KyleSmith on 2017/08/26.
 */
public class DBTeamIDs extends SQLiteOpenHelper{

    //Vars
    //Database naming of the database tables in database and columns of the database

    private static final String DATABASE_NAME = "Team_IDs.db";

    private static final String TABLE_NAME1 = "Team_ID_table";

    private static final String TBL_1_COL_1 = "Team_name";

    private static final String TBL_1_COL_2 = "Team_number";

    public DBTeamIDs(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME1 + " (Team_name TEXT, Team_number TEXT)");
        db.execSQL("INSERT INTO " + TABLE_NAME1 + " (Team_name, Team_number ) VALUES('Null&Void', '14014')");
        db.execSQL("INSERT INTO " + TABLE_NAME1 + " (Team_name, Team_number ) VALUES('Geared Wings', '12345')");
        db.execSQL("INSERT INTO " + TABLE_NAME1 + " (Team_name, Team_number ) VALUES('The spinners', '14567')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

    }

    //Getter that returns all the data from the database table 1
    public ArrayList<TeamQualities> getData(){

        SQLiteDatabase db = this.getWritableDatabase();
        //Way to receive data(Stores data in object)
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME1 + ";", null);
        ArrayList<TeamQualities> arrlData = new ArrayList<>();
        //Cursor checks if there is data in the next line and decides whether to continue
        while (res.moveToNext()){
            //Player stats constructor needs a string, int and int so in one line we have a position 0, 1 ,2
            //Adds data to an arraylist
            arrlData.add(new TeamQualities(res.getString(0), res.getString(1)));


        }

        return arrlData;
    }

    public ArrayList<String> getTeamNumber(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT " + TBL_1_COL_2 + " FROM " + TABLE_NAME1 + ";", null);
        ArrayList<String> arrlData = new ArrayList<>();
        while (res.moveToNext()){

            arrlData.add(res.getString(0));

        }

        return arrlData;
    }



    public boolean insertTeam(String sTeamNumber, String sTeamName){
        SQLiteDatabase db = getWritableDatabase();
        //Allows us to insert data and checks that data matches
        ContentValues contentValue = new ContentValues();
        contentValue.put(TBL_1_COL_1, sTeamName);
        contentValue.put(TBL_1_COL_2, sTeamNumber);
        long result = db.insert(TABLE_NAME1, null, contentValue);
        if(result == -1){

            return false;

        }else {

            return true;

        }


    }

    //TODO: Check this method out not sure how it works?
    public boolean deleteTeam(String sTeamNumber){

        SQLiteDatabase db = this.getWritableDatabase();
        int iDeleteData = db.delete(TABLE_NAME1, "Name = ?", new String[]{sTeamNumber});

        //Returns how many rows of data has been deleted and db.delete method is used to protect the app against a sql injection
        if(iDeleteData > 0){

            return true;

        }else{

            return false;

        }

    }


}
