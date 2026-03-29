package com.ticketb.ticketb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "test")
public class TestObject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
        name = "some_seq",
        sequenceName = "some_seq",
        allocationSize = 1
    )
    private Long id;

    //getter and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
