package net.tjololo.poc.spring.services;

import net.tjololo.poc.spring.transferobjects.Actor;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by veg on 17.10.2016.
 */
@Component
public class ActorServiceFallback implements ActorService {
    @Override
    public Resources<Actor> getAllActors() {
        return new Resources<>(Collections.EMPTY_LIST);
    }
}
