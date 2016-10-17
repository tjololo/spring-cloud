package net.tjololo.poc.spring.controllers;

import net.tjololo.poc.spring.services.ActorService;
import net.tjololo.poc.spring.transferobjects.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by veg on 17.10.2016.
 */
@RestController
@RequestMapping("/")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(value = "/actors")
    public Collection<Actor> getAll() {
        return actorService.getAllActors().getContent();
    }
}
