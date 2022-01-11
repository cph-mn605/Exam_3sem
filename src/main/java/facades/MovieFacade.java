package facades;

import dtos.MovieDTO;
import dtos.MoviesDTO;
import entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovieFacade {
    private static EntityManagerFactory emf;
    private static MovieFacade instance;

    public MovieFacade() {
    }

    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    public MovieDTO getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Movie movie = em.find(Movie.class, id);
        em.getTransaction().commit();
        em.close();
        if (movie != null) {
            movie.setId(id);
            return new MovieDTO(movie);
        } else {
            return null;
        }
    }

    public MoviesDTO getAllMovies() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery <Movie> typedQuery = em.createQuery("SELECT m from Movie m", Movie.class);
            List<Movie> movieList = typedQuery.getResultList();
            MoviesDTO moviesDTO = new MoviesDTO(movieList);
            em.getTransaction().commit();
            return moviesDTO;
        } finally {
            em.close();
        }
    }
}
