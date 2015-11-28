package com.example.analytics.dbious.busyfit;

public class Recipe {
    private int recipesID;
    private String name;
    private int calories;
    private int protein;
    private int carbs;
    private String instructions;


    public Recipe() {}
    public Recipe(int recipesID, String name, int calories, int protein, int carbs, String instructions)
    {
        this.recipesID = recipesID;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.instructions = instructions;
    }

    //setters
    public void setRecipesID(int recipesID)
    {
        this.recipesID = recipesID;
    }
    public void setName(String name)
    {
        this.name = name;
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
    public void setInstructions(String instructions)
    {
        this.instructions = instructions;
    }

    //getters
    public int getRecipesID()
    {
        return this.recipesID;
    }
    public String getName()
    {
        return this.name;
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
    public String getInstructions()
    {
        return this.instructions;
    }
}
