package com.example.hollis.gson_example;

/**
 * Created by hollis on 7/18/16.
 */
public class MarvelResult {
    public MarvelTeam[] teams;

    public MarvelResult(MarvelTeam[] teams) {
        this.teams = teams;
    }

    public MarvelTeam[] getTeams() {
        return teams;
    }

    public void setTeams(MarvelTeam[] teams) {
        this.teams = teams;
    }
}
