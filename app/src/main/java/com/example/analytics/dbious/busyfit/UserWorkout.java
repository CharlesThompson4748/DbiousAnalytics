package com.example.analytics.dbious.busyfit;

public class UserWorkout {
    private int userID;
    private int workoutID;

    public UserWorkout() {}
    public UserWorkout(int userID,int muscleID)
    {
        this.workoutID = muscleID;
        this.userID = userID;
    }

    //setters
    public void setUserID(int userID)
    {
        this.userID = userID;
    }
    public void setWorkoutID(int workoutID)
    {
        this.workoutID = workoutID;
    }

    //getters
    public int getUserID()
    {
        return this.userID;
    }
    public int getWorkoutID()
    {
        return this.workoutID;
    }
}
