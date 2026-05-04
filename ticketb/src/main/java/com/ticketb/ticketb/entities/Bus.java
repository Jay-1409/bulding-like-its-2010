package com.ticketb.ticketb.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "booking_seq",
            sequenceName = "booking_seq",
            allocationSize = 1
    )
    private Long bus_id;
    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();
}