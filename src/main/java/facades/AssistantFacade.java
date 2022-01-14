package facades;

import dtos.AssistantDTO;
import dtos.AssistantsDTO;
import entities.Assistant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AssistantFacade {
    private static EntityManagerFactory emf;
    private static AssistantFacade instance;

    public static AssistantFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AssistantFacade();
        }
        return instance;
    }

    public AssistantsDTO getAllAssistants() {
        EntityManager em = emf.createEntityManager();

        try{
            TypedQuery<Assistant> query = em.createQuery("SELECT a from Assistant a", Assistant.class);
            List<Assistant> result = query.getResultList();
            return new AssistantsDTO(result);
        } finally {
            em.close();
        }
    }

    public Assistant createAssistant(Assistant assistant) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            assistant.setName(assistant.getName());
            assistant.setLanguage(assistant.getLanguage());
            assistant.setYearExperience(assistant.getYearExperience());
            assistant.setPriceHour(assistant.getPriceHour());

            em.persist(assistant);
            em.getTransaction().commit();
        } finally {
            em.close();
        } return assistant;
    }



}
