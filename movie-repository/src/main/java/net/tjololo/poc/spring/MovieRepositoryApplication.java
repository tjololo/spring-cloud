package net.tjololo.poc.spring;

import net.tjololo.poc.spring.entities.Actor;
import net.tjololo.poc.spring.entities.Movie;
import net.tjololo.poc.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MovieRepositoryApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MovieRepositoryApplication.class, args);
        MovieRepository movieRepository = context.getBean(MovieRepository.class);
        Actor ryan = new Actor("Ryan", "Reynolds");
        Iterable<Movie> movies = Arrays.asList(
                new Movie("Star Wars: The Force Awakens",
                        Arrays.asList(
                                new Actor("Daisy", "Ridley"),
                                new Actor("Harrison", "Ford")
                        )
                ),
                new Movie("Deadpool",
                        Arrays.asList(
                                ryan,
                                new Actor("Karan", "Soni")
                        )
                ),
                new Movie("Deadpool 2",
                        Arrays.asList(
                                ryan,
                                new Actor("Kyle", "Chandler")
                        )
                ),
                new Movie("Equilibrium ",
                        Arrays.asList(
                                new Actor("Christian", "Bale"),
                                new Actor("Dominic", "Purcell")
                        )
                )
        );
        movieRepository.save(movies);

    }
}