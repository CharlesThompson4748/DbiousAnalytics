package com.example.analytics.dbious.busyfit;

public class WorkoutSchedule {

    private int id;
    private String name;
    private int weekPart;
    private int dayPart;
    private int hourPart;
    private int muscleGroupID1;
    private int muscleGroupID2;
    private String desc;

    WorkoutSchedule() {}
    WorkoutSchedule(int id, String name, int weekPart, int dayPart, int hourPart, int muscleGroupID1, int muscleGroupID2, String desc)
    {
        this.id = id;
        this.name = name;
        this.weekPart = weekPart;
        this.dayPart = dayPart;
        this.hourPart = hourPart;
        this.muscleGroupID1 = muscleGroupID1;
        this.muscleGroupID2 = muscleGroupID2;
        this.desc = desc;
    }

    //setters
    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setWeekPart(int weekPart)
    {
        this.weekPart = weekPart;
    }
    public void setDayPart(int dayPart)
    {
        this.dayPart = dayPart;
    }
    public void setHourPart(int hourPart)
    {
        this.hourPart = hourPart;
    }
    public void setMuscleGroupID1(int muscleGroupID1)
    {
        this.muscleGroupID1 = muscleGroupID1;
    }
    public void setMuscleGroupID2(int muscleGroupID2)
    {
        this.muscleGroupID2 = muscleGroupID2;
    }
    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    //getters
    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public int getWeekPart()
    {
        return this.weekPart;
    }
    public int getDayPart()
    {
        return this.dayPart;
    }
    public int getHourPart()
    {
        return this.hourPart;
    }
    public int getMuscleGroupID1()
    {
        return this.muscleGroupID1;
    }
    public int getMuscleGroupID2()
    {
        return this.muscleGroupID2;
    }
    public String getDesc()
    {
        return this.desc;
    }
}