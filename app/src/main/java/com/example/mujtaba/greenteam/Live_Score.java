package com.example.mujtaba.greenteam;

/**
 * Created by Mujtaba on 1/6/2019.
 */

public class Live_Score {
    private String team1;
    private String team2;
    private String series;
    private String type;
    private String matchstate;
    private String matchstatus;
    private String Toss;
    private String decision;
    private batsmen batsmen1;
    private batsmen batsmen2;
    private bowler bowler1;
    private bowler bowler2;
    private String t1score;

    public String getT1score() {
        return t1score;
    }

    public String getT1over() {
        return t1over;
    }

    public String getT2score() {
        return t2score;
    }

    public String getT2over() {
        return t2over;
    }

    public Live_Score(String team1, String team2, String series, String type, String matchstate, String matchstatus, String toss, String decision, batsmen batsmen1, batsmen batsmen2, bowler bowler1, bowler bowler2, String t1score, String t1over, String t2score, String t2over) {
        this.team1 = team1;
        this.team2 = team2;
        this.series = series;
        this.type = type;
        this.matchstate = matchstate;
        this.matchstatus = matchstatus;
        Toss = toss;
        this.decision = decision;
        this.batsmen1 = batsmen1;
        this.batsmen2 = batsmen2;
        this.bowler1 = bowler1;
        this.bowler2 = bowler2;
        this.t1score = t1score;
        this.t1over = t1over;
        this.t2score = t2score;
        this.t2over = t2over;
    }

    private String t1over;
    private String t2score;
    private String t2over;

    public Live_Score(String team1, String team2, String series, String type, String matchstate, String matchstatus, String toss, String decision,batsmen bat1,batsmen bat2,bowler bowl1,bowler bowl2) {
        this.team1 = team1;
        this.team2 = team2;
        this.series = series;
        this.type = type;
        this.matchstate = matchstate;
        this.matchstatus = matchstatus;
        Toss = toss;
        this.decision = decision;
        batsmen1 =bat1;
        batsmen2 = bat2;
        bowler1= bowl1;
        bowler2 = bowl2;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getSeries() {
        return series;
    }

    public String getType() {
        return type;
    }

    public String getMatchstate() {
        return matchstate;
    }

    public String getMatchstatus() {
        return matchstatus;
    }

    public String getToss() {
        return Toss;
    }

    public String getDecision() {
        return decision;
    }

    public batsmen getBatsmen1() {
        return batsmen1;
    }

    public batsmen getBatsmen2() {
        return batsmen2;
    }

    public bowler getBowler1() {
        return bowler1;
    }

    public bowler getBowler2() {
        return bowler2;
    }
}
