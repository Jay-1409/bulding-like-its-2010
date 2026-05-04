package com.ticketb.ticketb.entities;

import jakarta.persistence.*;
import com.ticketb.ticketb.entities.*;

import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long b_id;

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "username", nullable = false)
    private User u_id;

    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "bus_id", nullable = false)
    private Bus bus;
    @ManyToMany
    @JoinTable(
            name = "booking_seats",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;
    boolean status;

    public Long getB_id() {
        return b_id;
    }

    public void setB_id(Long b_id) {
        this.b_id = b_id;
    }

    public User getU_id() {
        return u_id;
    }

    public void setU_id(User u_id) {
        this.u_id = u_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Booking() {
        status = false;
    }
}
