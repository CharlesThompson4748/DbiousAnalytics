package com.example.analytics.dbious.busyfit;

public class UserDiet {
    private int userID;
    private int foodID;

    public UserDiet() {}
    public UserDiet(int userID,int foodID)
    {
        this.foodID = foodID;
        this.userID = userID;
    }

    //setters
    public void setUserID(int userID)
    {
        this.userID = userID;
    }
    public void setFoodID(int foodID)
    {
        this.foodID = foodID;
    }

    //getters
    public int getUserID()
    {
        return this.userID;
    }
    public int getFoodID()
    {
        return this.foodID;
    }
}
