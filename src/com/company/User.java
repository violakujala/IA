package com.company;

import java.io.Serializable;
import java.util.LinkedList;

public class User implements Serializable {
    public User (String username, String password, LinkedList events)
    {
        this.username = username;
        this.password = password;
        this.events = events;

        eventss = new Event [9][365];
        jan = new Event[9][31];
        feb = new Event[9][28];
        mar = new Event[9][31];
        apr = new Event[9][30];
        may = new Event[9][31];
        jun = new Event[9][30];
        jul = new Event[9][31];
        aug = new Event[9][31];
        sep = new Event[9][30];
        oct = new Event[9][31];
        nov = new Event[9][30];
        dec = new Event[9][31];

        events.add(jan);
        events.add(feb);
        events.add(mar);
        events.add(apr);
        events.add(may);
        events.add(jun);
        events.add(jul);
        events.add(aug);
        events.add(sep);
        events.add(oct);
        events.add(nov);
        events.add(dec);
    }
    public String username;
    public String password;
    public LinkedList events;
    public Event[][] eventss;
    public Event[][] jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec;

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }
    public LinkedList getEvents ()
    {
        return this.events;
    }
}
