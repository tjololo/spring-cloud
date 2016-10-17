package net.tjololo.poc.spring.transferobjects;

/**
 * Created by veg on 17.10.2016.
 */
public class Actor {
    private String firstname;
    private String lastname;

    public Actor() {
    }

    public Actor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
