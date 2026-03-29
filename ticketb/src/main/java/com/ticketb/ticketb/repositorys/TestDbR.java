package com.ticketb.ticketb.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketb.ticketb.entities.TestObject;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDbR extends JpaRepository<TestObject, Long> {
}