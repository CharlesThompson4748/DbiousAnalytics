package com.example.analytics.dbious.busyfit;

public class Workout {
    private String name;
    private int WOSchedID;
    private int time;
    private int calPerTime;

    public Workout() {}
    public Workout(String name, int WOSchedID, int time, int calPerTime)
    {
        this.name = name;
        this.WOSchedID = WOSchedID;
        this.time = time;
        this.calPerTime = calPerTime;
    }

    //setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setWOSchedID(int WOSchedID)
    {
        this.WOSchedID = WOSchedID;
    }
    public void setTime(int time)
    {
        this.time = time;
    }
    public void setCalPerTime(int calPerTime)
    {
        this.calPerTime = calPerTime;
    }

    //getters
    public String getName()
    {
        return this.name;
    }
    public int getWOSchedID()
    {
        return this.WOSchedID;
    }
    public int getTime()
    {
        return this.time;
    }
    public int getCalPerTime()
    {
        return this.calPerTime;
    }
}
