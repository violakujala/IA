package com.company;

public class Event{
    public Event(int time, int day, String month,  String name, String description )
    {
        this.time = time;
        this.day = day;
        this.month = month;
        this.name = name;
        this.description = description;

    }
    public int time, day;
    public String month, name, description;


    public String getMonth()
    {
        return this.month;
    }
    public int getDay()
    {
        return this.day;
    }
    public int getTime()
    {
        return this.time;
    }
    public String getName()
    {
        return this.name;
    }

}
