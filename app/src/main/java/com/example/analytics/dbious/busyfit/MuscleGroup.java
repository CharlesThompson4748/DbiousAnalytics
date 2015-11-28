package com.example.analytics.dbious.busyfit;

public class MuscleGroup {
    private int muscleID;
    private String muscleGroup;

    public MuscleGroup() {}
    public MuscleGroup(int muscleID, String muscleGroup)
    {
        this.muscleID = muscleID;
        this.muscleGroup = muscleGroup;
    }

    //setters
    public void setMuscleID(int muscleID)
    {
        this.muscleID = muscleID;
    }
    public void setMuscleGroup(String muscleGroup)
    {
        this.muscleGroup = muscleGroup;
    }

    //getters
    public int getMuscleID()
    {
        return this.muscleID;
    }
    public String getMuscleGroup()
    {
        return this.muscleGroup;
    }
}
