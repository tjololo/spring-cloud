package net.tjololo.poc.spring.repository;

import net.tjololo.poc.spring.entities.Movie;
import net.tjololo.poc.spring.entities.projections.MovieP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * Created by tjololo on 28.09.2016.
 */
@RepositoryRestResource(excerptProjection = MovieP.class)
@RepositoryRestController
public interface ProjectionMovieRepository  extends CrudRepository<Movie, Integer>{
}
