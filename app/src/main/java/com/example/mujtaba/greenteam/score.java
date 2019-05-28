package com.example.mujtaba.greenteam;

/**
 * Created by users12 on 10/12/2018.
 */

public class score {
    String team1,team2,team1Total,team2Total,team1Overs,team2Overs,tossWin,id,series;

    public score(String team1, String team2, String team1Total, String team2Total, String tossWin, String id) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Total = team1Total;
        this.team2Total = team2Total;
        this.tossWin = tossWin;
        this.id = id;

    }

    public score(String series,String team1, String team2, String team1Total, String team2Total,String team1Overs ,String team2Overs,String tossWin) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Total = team1Total;
        this.team2Total = team2Total;
        this.tossWin = tossWin;
        this.team1Overs=team1Overs;
        this.team2Overs = team2Overs;
        this.series=series;
    }

    public score() {
    }

}
