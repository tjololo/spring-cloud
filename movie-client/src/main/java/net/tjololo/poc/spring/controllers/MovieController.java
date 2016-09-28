package net.tjololo.poc.spring.controllers;

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

import java.util.Collection;
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
    public Collection<Movie> getMovies() {
        return restTemplate
                .exchange(
                        repositoryURI + "/movies",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Resources<Movie>>() {
                        }
                )
                .getBody()
                .getContent();
    }

    @RequestMapping(value = "titles", method = RequestMethod.GET)
    public Collection<String> getTitles() {
        return restTemplate
                .exchange(
                        repositoryURI + "/movies",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Resources<Movie>>() {
                        }
                )
                .getBody()
                .getContent()
                .stream()
                .map(Movie::getTitle)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
