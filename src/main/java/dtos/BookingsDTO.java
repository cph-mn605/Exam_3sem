package dtos;

import entities.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingsDTO {
    List<BookingDTO> bookings = new ArrayList<>();

    public BookingsDTO(List<Booking> entity) {
        entity.forEach((booking -> {
            bookings.add(new BookingDTO(booking));
        }));
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "BookingsDTO{" +
                "bookings=" + bookings +
                '}';
    }
}
