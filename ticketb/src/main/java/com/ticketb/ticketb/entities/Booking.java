package com.ticketb.ticketb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
        name = "booking_seq",
        sequenceName = "booking_seq",
        allocationSize = 1
    )
    private Long b_id;

    @ManyToOne
    @JoinColumn(
        name = "u_id",
        referencedColumnName = "username",
        nullable = false
    )
    private User u_id;

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
