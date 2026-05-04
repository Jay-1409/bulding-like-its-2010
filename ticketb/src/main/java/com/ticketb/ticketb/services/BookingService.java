package com.ticketb.ticketb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketb.ticketb.entities.Booking;
import com.ticketb.ticketb.repositorys.BookingRepo;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    public void innitSeats() {
        
    }
}