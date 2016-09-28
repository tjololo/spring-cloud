package net.tjololo.poc.spring.transferobjects;

import java.util.List;

/**
 * Created by tjololo on 28.09.2016.
 */
public class Movie {
    private String title;
    private List<Actor> actors;

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }
}
