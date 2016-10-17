package net.tjololo.poc.spring.services;

import net.tjololo.poc.spring.transferobjects.Actor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by veg on 17.10.2016.
 */
@FeignClient(serviceId = "movie-registry", fallback = ActorServiceFallback.class)
public interface ActorService {
    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    Resources<Actor> getAllActors();
}
