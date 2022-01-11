package dtos;

import entities.Movie;

import java.util.List;

public class MoviesDTO {
    private List<MovieDTO> movies;

    public MoviesDTO(List<Movie> movies) {
        this.movies = MovieDTO.getFromList(movies);
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }
}
