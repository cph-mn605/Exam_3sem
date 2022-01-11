package dtos;

import entities.Actor;
import entities.Movie;
import java.util.List;
import java.util.stream.Collectors;

public class MovieDTO {
    private Integer id;
    private int year;
    private String title;
    private double rating;
    List<ActorDTO> actors;

    public static List<MovieDTO> getFromList(List<Movie> movies) {
        return movies.stream()
                .map(movie -> new MovieDTO(movie))
                .collect(Collectors.toList());
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.year = movie.getYear();
        this.title = movie.getTitle();
        this.rating = movie.getRating();
        this.actors = ActorDTO.getFromList(movie.getActors());
    }

    public MovieDTO(int year, String title, double rating, List<ActorDTO> actors) {
        this.id = -1;
        this.year = year;
        this.title = title;
        this.rating = rating;
        this.actors = actors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", actors=" + actors +
                '}';
    }
}
