package facades;

import dtos.BookingDTO;
import dtos.BookingsDTO;
import entities.Booking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookingFacade {
    private static EntityManagerFactory emf;
    private static BookingFacade instance;

    public static BookingFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookingFacade();
        }
        return instance;
    }

    public BookingsDTO getAllBookings() {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Booking> query = em.createQuery("SELECT b from Booking b", Booking.class);
            List<Booking> result = query.getResultList();
            return new BookingsDTO(result);
        } finally {
            em.close();
        }
    }

    public boolean deleteBooking(int id) {
        EntityManager em = emf.createEntityManager();
        Booking booking;
        try {
            booking = em.find(Booking.class, id);
            em.getTransaction().begin();
            em.remove(booking);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            em.close();
        }
        return true;
    }

    public boolean deleteBooking(BookingDTO dto) {
        return deleteBooking(dto.getId());
    }
}
