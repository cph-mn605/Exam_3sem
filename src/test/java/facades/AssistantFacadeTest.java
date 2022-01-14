package facades;

import dtos.AssistantsDTO;
import entities.Assistant;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

class AssistantFacadeTest {
    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
    private static final AssistantFacade instance = AssistantFacade.getInstance(emf);
    private static EntityManager em = emf.createEntityManager();

    @BeforeAll
    static void setupAll() {
        Assistant as1 = new Assistant("TestName", "TestLanguage", 1, 1);
        Assistant as2 = new Assistant("TestName", "TestLanguage", 1, 1);

        em.getTransaction().begin();
        em.persist(as1);
        em.persist(as2);
        em.getTransaction().commit();
    }

    public AssistantFacadeTest() {
    }

    @Test
    public void getAllAssistants() {
        try {
            em.getTransaction().begin();
            AssistantsDTO result = instance.getAllAssistants();
            em.getTransaction().commit();

            System.out.println(result);
            assertEquals(2, result.getAssistants().size());
        } finally {
           em.close();
        }
    }
        @AfterEach
        void tearDown() {
            EntityManager em = emf.createEntityManager();
        }

        @Test
        void createAssistans() {
            EntityManager em = emf.createEntityManager();
        }
    }