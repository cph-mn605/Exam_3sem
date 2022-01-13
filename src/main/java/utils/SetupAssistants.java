package utils;

import entities.Assistant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupAssistants {
    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Assistant assistant1 = new Assistant("Adam", "English", 2, 120);
        Assistant assistant2 = new Assistant("Jesper", "Svensk", 4,130);
        Assistant assistant3 = new Assistant("Lina", "Tysk", 1, 125);

        em.getTransaction().begin();
        em.persist(assistant1);
        em.persist(assistant2);
        em.persist(assistant3);
        em.getTransaction().commit();
    }
}
