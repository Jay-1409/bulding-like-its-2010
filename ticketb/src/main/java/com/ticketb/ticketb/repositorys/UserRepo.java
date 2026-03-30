package com.ticketb.ticketb.repositorys;

import com.ticketb.ticketb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {}
