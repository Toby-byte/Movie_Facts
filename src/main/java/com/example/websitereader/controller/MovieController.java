package com.example.websitereader.controller;

import com.example.websitereader.models.Movie;
import com.example.websitereader.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @GetMapping("/")
    public String index() {
    return "Hello word";
    }

    @GetMapping("/getFirst")
    public String index2() {
        MovieService movieService = new MovieService();
        return movieService.getMovie();
    }

    @GetMapping("/getRandom")
    public String index3() {
        MovieService movieService = new MovieService();
        return String.valueOf(movieService.getRandomMovie());
    }

    @GetMapping("/getAll")
    public String index4() {
        MovieService movieService = new MovieService();
        return movieService.getAllMovies();
    }

    @GetMapping("/getSortTenMovies")
    public List<Movie> index5() {
        MovieService movieService = new MovieService();
        return movieService.getSortTenMoviesByPop();
    }

    @GetMapping("/getAllAwardMovies")
    public String index6() {
        MovieService movieService = new MovieService();
        return movieService.getAllAwardMovies();
    }
}
