package entities;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "booking.getAllRows", query = "SELECT b from Booking b")
})

@Table(name = "booking")
@Entity
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    //Variables
    private Integer id;

    @Column(name="dateTime")
    private String dateTime;

    @Column(name="duration")
    private int duration;

    //constructor


    public Booking(String dateTime, int duration) {
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public Booking() {
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