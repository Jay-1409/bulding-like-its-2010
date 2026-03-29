package com.ticketb.ticketb.services;

import com.ticketb.ticketb.entities.TestObject;
import com.ticketb.ticketb.repositorys.TestDbR;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TestDb {

    private final TestDbR testDbR;

    public TestDb(TestDbR testDbR) {
        this.testDbR = testDbR;
    }

    public List<TestObject> TestConnection() {
        return testDbR.findAll();
    }
}
