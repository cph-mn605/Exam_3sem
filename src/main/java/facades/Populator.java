package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.Actor;
import entities.Movie;
import utils.EMF_Creator;

public class Populator {

    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Movie movie1 = new Movie(1999, "Harry Potter", 7.5);
        Movie movie2 = new Movie(2019, "Endgame", 9.5);

        Actor actor1 = new Actor("Emma Watson");
        Actor actor2 = new Actor("Tom Holland");
        Actor actor3 = new Actor("Frederik");
        Actor actor4 = new Actor("Janus");
        Actor actor5 = new Actor("Julius");

        movie1.addActor(actor1);
        movie1.addActor(actor2);
        movie2.addActor(actor3);
        movie2.addActor(actor4);
        movie2.addActor(actor5);


        em.getTransaction().begin();
        em.persist(movie1);
        em.persist(movie2);
        em.getTransaction().commit();
    }

    public static void main(String[] args) {
        populate();
    }


}
