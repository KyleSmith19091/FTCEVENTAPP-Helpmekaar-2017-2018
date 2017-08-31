package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Model;

/**
 * Created by KyleSmith on 2017/08/27.
 */
public class TeamQualities {

    //Vars
    private String sTeamName;

    private String sTeamNumber;

    private String sTeamScore;

    public TeamQualities(){
    }

    //Constructor for both vars
    public TeamQualities(String sTeamName, String sTeamNumber, String sTeamScore) {
        this.sTeamName = sTeamName;
        this.sTeamNumber = sTeamNumber;
        this.sTeamScore = sTeamScore;
    }

    //Constructor for teamnumber
    public TeamQualities(String sTeamNumber){

        this.sTeamNumber = sTeamNumber;

    }

    //Getters and setters for the tow vars the team name and team number
    public String getsTeamName() {
        return sTeamName;
    }

    public void setsTeamName(String sTeamName) {
        this.sTeamName = sTeamName;
    }

    public String getsTeamNumber() {
        return sTeamNumber;
    }

    public void setsTeamNumber(String sTeamNumber) {
        this.sTeamNumber = sTeamNumber;
    }

    public String getsTeamScore() {
        return sTeamScore;
    }

    public void setsTeamScore(String sTeamScore) {
        this.sTeamScore = sTeamScore;
    }




}
