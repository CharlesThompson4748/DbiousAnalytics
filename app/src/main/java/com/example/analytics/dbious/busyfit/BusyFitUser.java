package com.example.analytics.dbious.busyfit;

public class BusyFitUser {
    private String fname;
    private String lname;
    private String email;

    public BusyFitUser() {}
    public BusyFitUser(String fname, String lname, String email)
    {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    //setters
    public void setFName(String fname)
    {
        this.fname = fname;
    }
    public void setLName(String lname)
    {
        this.lname = lname;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    //getters
    public String getFName()
    {
        return this.fname;
    }
    public String getLName()
    {
        return this.lname;
    }
    public String getEmail()
    {
        return this.email;
    }
}