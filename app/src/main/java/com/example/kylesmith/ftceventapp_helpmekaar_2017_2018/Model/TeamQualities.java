package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Model;

/**
 * Created by KyleSmith on 2017/08/27.
 */
public class TeamQualities {

    //Vars
    private String sTeamName;

    private String sTeamNumber;

    //Constructor for both vars
    public TeamQualities(String sTeamName, String sTeamNumber) {
        this.sTeamName = sTeamName;
        this.sTeamNumber = sTeamNumber;
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
}
