package net.tjololo.poc.spring.entities.projections;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by tjololo on 28.09.2016.
 */
@Projection(types = {net.tjololo.poc.spring.entities.Actor.class}, name = "actor")
public interface ActorP {
    String getFirstname();

    String getLastname();
}
