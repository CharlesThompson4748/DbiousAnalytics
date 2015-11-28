package com.example.analytics.dbious.busyfit;

public class RecipeVideo {
    private int recipeId;
    private String videoUrl;

    public RecipeVideo() {}
    public RecipeVideo(int recipeId, String recipeUrl)
    {
        this.recipeId = recipeId;
        this.videoUrl = videoUrl;
    }

    //setters
    public void setRecipeId(int recipeId)
    {
        this.recipeId = recipeId;
    }
    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }

    //getters
    public int getRecipeId()
    {
        return this.recipeId;
    }
    public String getVideoUrl()
    {
        return this.videoUrl;
    }
}
