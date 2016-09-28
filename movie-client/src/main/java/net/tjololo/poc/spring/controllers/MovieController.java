package net.tjololo.poc.spring.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.tjololo.poc.spring.transferobjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tjololo on 28.09.2016.
 */
@RestController
@RequestMapping("/movies")
public class MovieController {
    private RestTemplate restTemplate;
    private String repositoryURI;

    @Autowired
    public MovieController(RestTemplate restTemplate, @Value("${repository.uri}") String repositoryURI) {
        this.restTemplate = restTemplate;
        this.repositoryURI = repositoryURI;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMovies")
    public Collection<Movie> getMovies() {
        return getMoviesFromRepository("?projection=movie");
    }

    @RequestMapping(value = "titles", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackString")
    public Collection<String> getTitles() {
        return getMoviesFromRepository("")
                .stream()
                .map(Movie::getTitle)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private Collection<Movie> getMoviesFromRepository(String requestParams) {
        return restTemplate
                .exchange(
                        repositoryURI + "/movies" + requestParams,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Resources<Movie>>() {
                        }
                )
                .getBody()
                .getContent();
    }

    public Collection<Movie> fallbackMovies() {
        return Collections.emptyList();
    }

    public Collection<String> fallbackTitle() {
        return Collections.emptyList();
    }
}
