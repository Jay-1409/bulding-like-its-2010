package com.ticketb.ticketb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TicketbApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketbApplication.class, args);
    }
}
