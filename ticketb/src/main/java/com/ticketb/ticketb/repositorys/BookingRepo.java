package com.ticketb.ticketb.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketb.ticketb.entities.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
	
}
