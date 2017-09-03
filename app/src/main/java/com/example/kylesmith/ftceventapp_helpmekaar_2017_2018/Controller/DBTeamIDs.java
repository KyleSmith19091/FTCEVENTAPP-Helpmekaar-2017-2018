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

    private static final String TBL_1_COL_3 = "Score";

    public DBTeamIDs(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    ////////////////////
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME1 + " (Team_name TEXT, Team_number TEXT, Score TEXT)");
        db.execSQL("INSERT INTO " + TABLE_NAME1 + " (Team_name, Team_number, Score ) VALUES('Null&Void', '14014', '125')");
        db.execSQL("INSERT INTO " + TABLE_NAME1 + " (Team_name, Team_number, Score ) VALUES('Geared Wings', '12345', '345')");
        db.execSQL("INSERT INTO " + TABLE_NAME1 + " (Team_name, Team_number, Score ) VALUES('The Spanners', '14567', '500')");
        db.execSQL("INSERT INTO " + TABLE_NAME1 + " (Team_name, Team_number, Score ) VALUES('RoboWranglers', '14568', '700')");

    }
    //////////////////

    /////////////////
    //Checks if a database has already been created if not it will create one
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

    }
    ////////////////

    //Getter that returns all the data from the database table 1
    public ArrayList<TeamQualities> getData(){

        SQLiteDatabase db = this.getWritableDatabase();
        //Way to receive data(Stores data in object)
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME1 + " ORDER BY " + TBL_1_COL_3 + " DESC " + ";", null);
        ArrayList<TeamQualities> arrlData = new ArrayList<>();
        //Cursor checks if there is data in the next line and decides whether to continue
        while (res.moveToNext()){
            //Player stats constructor needs a string, int and int so in one line we have a position 0, 1 ,2
            //Adds data to an arraylist
            arrlData.add(new TeamQualities(res.getString(0), res.getString(1), res.getString(2)));


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

    public ArrayList<Integer> getTeamScore(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT " + TBL_1_COL_3 + " FROM " + TABLE_NAME1 + ";", null);
        Integer.parseInt(res.toString());
        ArrayList<Integer> arrlData = new ArrayList<>();
        while (res.moveToNext()){

            arrlData.add(res.getInt(0));

        }

        return arrlData;
    }



    //Inserts a team into the databse and the correct table if needed and check if values match up t prevent a SQL attack
    public boolean insertTeam(String sTeamNumber, String sTeamName, String sTeamScore){
        SQLiteDatabase db = getWritableDatabase();
        //Allows us to insert data and checks that data matches
        ContentValues contentValue = new ContentValues();
        contentValue.put(TBL_1_COL_1, sTeamName);
        contentValue.put(TBL_1_COL_2, sTeamNumber);
        contentValue.put(TBL_1_COL_3, sTeamScore);
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

    public void updateGameStats(String sTeamNumber) {
//////////////////////////////////////////////////////////
        //Get the player stats of player
        SQLiteDatabase db = this.getWritableDatabase();
        //NB! If you ever get a error check this
        Cursor res = db.rawQuery("SELECT Team_score FROM " + TABLE_NAME1 + " WHERE Team_number = " + "'" + sTeamNumber + "'", null);

        ContentValues contentValue = new ContentValues();

        res.moveToNext();
        int wins = res.getInt(0);
        int played = res.getInt(1);

        contentValue.put(TBL_1_COL_2, wins);
        contentValue.put(TBL_1_COL_3, played);

        db.update(TABLE_NAME1, contentValue, "Name = ?", new String[]{sTeamNumber});

    }


}//End of the class
