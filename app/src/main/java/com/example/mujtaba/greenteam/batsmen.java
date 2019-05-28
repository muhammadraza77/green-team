package com.example.mujtaba.greenteam;

/**
 * Created by Mujtaba on 1/6/2019.
 */

public class batsmen {
    private String name;
    private String runs;
    private String balls;
    private String sixes;
    private String fours;

    public String getName() {
        return name;
    }

    public String getRuns() {
        return runs;
    }

    public String getBalls() {
        return balls;
    }

    public String getSixes() {
        return sixes;
    }

    public String getFours() {
        return fours;
    }

    public String getStrikerate() {
        return strikerate;
    }

    private String strikerate;

    public batsmen(String name, String runs, String balls, String fours, String sixes,String strikerate) {

        this.name = name;
        this.runs = runs;
        this.balls = balls;
        this.fours = fours;
        this.sixes = sixes;
        this.strikerate = strikerate;

    }
}
