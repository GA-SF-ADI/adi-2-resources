package com.example.hollis.gson_example;

/**
 * Created by audreyeso on 7/18/16.
 */
public class Query {
    private int count;
    private String created;
    private String lang;
    private Results results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
    //do I need to put channel in?
}
