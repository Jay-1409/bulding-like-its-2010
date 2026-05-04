package com.ticketb.ticketb.entities;

import com.ticketb.ticketb.entities.Bus;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
}