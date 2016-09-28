package net.tjololo.poc.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tjololo on 28.09.2016.
 */
@Entity
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @ManyToMany(targetEntity = Actor.class, cascade = CascadeType.PERSIST)
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(String title, List<Actor> actors) {
        this.title = title;
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
