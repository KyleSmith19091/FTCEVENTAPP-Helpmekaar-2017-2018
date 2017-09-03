package com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.Model.TeamQualities;
import com.example.kylesmith.ftceventapp_helpmekaar_2017_2018.R;

import java.util.ArrayList;

/**
 * Created by KyleSmith on 2017/08/30.
 */
public class Scoreboard_Teamqualities_Adapter extends ArrayAdapter<TeamQualities> {
    public Scoreboard_Teamqualities_Adapter(Context context, ArrayList<TeamQualities> TeamQualities) {
        super(context, 0, TeamQualities);
    }

    //Vars


    //It returns a view NB!!!
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_scoreboard_single_position, parent, false);

        }
        //Allows us to reference buttons or textviews to be used in java "form"
        TextView txtScore = (TextView) listItemView.findViewById(R.id.txtScore);

        TextView txtPos = (TextView) listItemView.findViewById(R.id.txtPosition);

        TextView txtTitle = (TextView) listItemView.findViewById(R.id.txtTitle);

        RelativeLayout rl = (RelativeLayout) listItemView.findViewById(R.id.rl);

        //This is an object for returning items from the model package for Team qualities
        TeamQualities currentList = getItem(position);

        txtScore.setText(currentList.getsTeamScore());

        txtPos.setText((position + 1) + "");

        txtTitle.setText(currentList.getsTeamName());

        return listItemView;

         }

    }
