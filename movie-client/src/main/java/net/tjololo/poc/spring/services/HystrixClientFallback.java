package net.tjololo.poc.spring.services;

import com.netflix.hystrix.HystrixCircuitBreaker;
import net.tjololo.poc.spring.transferobjects.Movie;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

/**
 * Created by veg on 05.10.2016.
 */
@Component
public class HystrixClientFallback implements MovieFeignService{

    @Override
    public Resources<Movie> findAll() {
        return new Resources<>(Collections.EMPTY_LIST);
    }

    @Override
    public Resources<Movie> findAllProjections(@RequestParam("projection") String projection) {
        return new Resources<>(Collections.EMPTY_LIST);
    }
}
