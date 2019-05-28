package com.example.mujtaba.greenteam;

/**
 * Created by Mujtaba on 1/6/2019.
 */

public class bowler {

    private String name;
    private String runs;
    private String overs;
    private String wickets;
    private String maiden;

    public String getName() {
        return name;
    }

    public String getRuns() {
        return runs;
    }

    public String getOvers() {
        return overs;
    }

    public String getWickets() {
        return wickets;
    }

    public String getMaiden() {
        return maiden;
    }

    public String getEconomy() {
        return economy;
    }

    private String economy;

    public bowler(String name,String overs, String maiden, String runs,String wickets) {
        this.name = name;
        this.runs = runs;
        this.overs = overs;
        this.wickets = wickets;
        this.maiden = maiden;
    }
}
