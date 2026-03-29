package com.ticketb.ticketb.controllers;

import com.ticketb.ticketb.entities.TestObject;
import com.ticketb.ticketb.services.TestDb;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Health {

    private TestDb testDb;

    public Health(TestDb testDb) {
        this.testDb = testDb;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return new ResponseEntity<>("SYSTEM IS HEALTHY", HttpStatus.OK);
    }

    @GetMapping("/test-connection")
    public ResponseEntity<List<TestObject>> testConnection() {
        try {
            List<TestObject> testObjects = testDb.TestConnection();
            return new ResponseEntity<>(testObjects, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
