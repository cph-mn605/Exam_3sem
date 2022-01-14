package dtos;

import entities.Booking;

import javax.persistence.Column;

public class BookingDTO {
    //Variables
    private Integer id;
    private String dateTime;
    private int duration;

    //Constructor
    public BookingDTO(Booking booking) {
        this.id = booking.getId();
        this.dateTime = booking.getDateTime();
        this.duration = booking.getDuration();
    }

    public BookingDTO(String dateTime, int duration) {
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
