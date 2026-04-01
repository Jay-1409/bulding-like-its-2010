package com.ticketb.ticketb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ticketb.ticketb.entities.User;
import com.ticketb.ticketb.repositorys.UserRepo;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public boolean CheckIfUserExists(String username){
        return userRepo.existsById(username);
    }
    public ResponseEntity<?> AddUser(User user) {
        if(CheckIfUserExists(user.getUsername())) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        User curusr = userRepo.save(user);
        return new ResponseEntity<>(curusr, HttpStatus.CREATED);
    }
    public ResponseEntity<?> Signup(User user) {
        if(CheckIfUserExists(user.getUsername())) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        User curusr = userRepo.save(user);
        return new ResponseEntity<>(curusr, HttpStatus.CREATED);
    }
    public ResponseEntity<?> Login(User user) {
        if(!CheckIfUserExists(user.getUsername())) {
            return new ResponseEntity<>("User does not exist", HttpStatus.NOT_FOUND);
        }
        User curusr = userRepo.findById(user.getUsername()).get();
        if(!curusr.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>("Invalid password", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(curusr, HttpStatus.OK);
    }
}
