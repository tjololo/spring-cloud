package net.tjololo.poc.spring.entities.projections;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by tjololo on 28.09.2016.
 */
@Projection(types = {net.tjololo.poc.spring.entities.Movie.class}, name = "movie")
public interface MovieP {
    String getTitle();

    List<ActorP> getActors();

}
