package net.tjololo.poc.spring.repository;

import net.tjololo.poc.spring.entities.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

/**
 * Created by tjololo on 28.09.2016.
 */
@Repository
@RepositoryRestController
public interface ActorRepository extends CrudRepository<Actor, Integer>{
}
