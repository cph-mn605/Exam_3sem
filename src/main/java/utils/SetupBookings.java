package utils;

import entities.Booking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupBookings {
    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Booking booking1 = new Booking("1/1-2021", 50);
        Booking booking2 = new Booking("12/5-2022", 35);
        Booking booking3 = new Booking("18/2-2021", 25);

        em.getTransaction().begin();
        em.persist(booking1);
        em.persist(booking2);
        em.persist(booking3);
        em.getTransaction().commit();
    }
}
