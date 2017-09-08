package com.example.dasha.scorekeepapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView teamAScore;
    TextView teamBScore;
    Button goalTeamA;
    Button goalTeamB;
    Button reset;

    int countTeamA = 0;
    int countTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAScore = (TextView)findViewById(R.id.count_teamA);
        teamAScore.setText(String.valueOf(countTeamA));
        teamBScore = (TextView)findViewById(R.id.count_teamB);
        teamBScore.setText(String.valueOf(countTeamB));

        goalTeamA = (Button) findViewById(R.id.btn_goal_teamA);
        goalTeamA.setOnClickListener(this);
        goalTeamB = (Button) findViewById(R.id.btn_goal_teamB);
        goalTeamB.setOnClickListener(this);
        reset = (Button) findViewById(R.id.btn_reset);
        reset.setOnClickListener(this);

    }



    protected void increaceGoalTeamA(){
        countTeamA++;
        teamAScore.setText(String.valueOf(countTeamA));
    }

    protected void increaceGoalTeamB(){
        countTeamB++;
        teamBScore.setText(String.valueOf(countTeamB));
    }

    protected void resetResult(){
        countTeamA = 0;
        teamAScore.setText(String.valueOf(countTeamA));
        countTeamB = 0;
        teamBScore.setText(String.valueOf(countTeamB));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_goal_teamA:
                increaceGoalTeamA();
                break;
            case R.id.btn_goal_teamB:
                increaceGoalTeamB();
                break;
            case R.id.btn_reset:
                resetResult();
        }
    }
}
