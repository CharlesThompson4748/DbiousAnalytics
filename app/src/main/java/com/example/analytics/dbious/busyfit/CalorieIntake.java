package com.example.analytics.dbious.busyfit;

public class CalorieIntake {
    private String foodName;
    private String UPC;
    private String date;
    private int calories;
    private int protein;
    private int carbs;

    public CalorieIntake() {}
    public CalorieIntake(String foodName, String UPC, String date, int calories, int protein, int carbs)
    {
        this.foodName = foodName;
        this.UPC = UPC;
        this.date = date;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
    }

    //setters
    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }
    public void setUPC(String UPC)
    {
        this.UPC = UPC;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public void setCalories(int calories)
    {
        this.calories = calories;
    }
    public void setProtein(int protein)
    {
        this.protein = protein;
    }
    public void setCarbs(int carbs)
    {
        this.carbs = carbs;
    }

    //getters
    public String getFoodName()
    {
        return this.foodName;
    }
    public String getUPC()
    {
        return this.UPC;
    }
    public String getDate()
    {
        return this.date;
    }
    public int getCalories()
    {
        return this.calories;
    }
    public int getProtein()
    {
        return this.protein;
    }
    public int getCarbs()
    {
        return this.carbs;
    }
}