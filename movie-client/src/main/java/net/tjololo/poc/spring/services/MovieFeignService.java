package net.tjololo.poc.spring.services;

import net.tjololo.poc.spring.transferobjects.Movie;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tjololo on 30.09.2016.
 */
@FeignClient(serviceId = "movie-registry")
public interface MovieFeignService {
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @LoadBalanced
    Resources<Movie> findAll();

    @RequestMapping(value = "/movies?projection={projection}", method = RequestMethod.GET)
    @LoadBalanced
    Resources<Movie> findAllProjections(@RequestParam("projection") String projection);
}
