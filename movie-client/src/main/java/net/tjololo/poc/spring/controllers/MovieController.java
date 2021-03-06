package net.tjololo.poc.spring.controllers;

import net.tjololo.poc.spring.services.MovieFeignService;
import net.tjololo.poc.spring.transferobjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by tjololo on 28.09.2016.
 */
@RestController
@RequestMapping("/")
public class MovieController {
    private MovieFeignService movieFeignService;

    @Autowired
    public MovieController(MovieFeignService movieFeignService) {
        this.movieFeignService = movieFeignService;
    }

    @RequestMapping(value = "movies", method = RequestMethod.GET)
    public Collection<Movie> getMovies() {
        return movieFeignService.findAllProjections("movie").getContent();
    }

    @RequestMapping(value = "movies/titles", method = RequestMethod.GET)
    public Collection<String> getTitles() {
        return movieFeignService.findAll()
                .getContent()
                .stream()
                .map(Movie::getTitle)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
