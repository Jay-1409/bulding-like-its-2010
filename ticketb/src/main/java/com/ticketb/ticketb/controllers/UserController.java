package com.ticketb.ticketb.controllers;

import com.ticketb.ticketb.entities.User;
import com.ticketb.ticketb.services.UserService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<?> add_user(@RequestBody User user) {
        try {
            return new ResponseEntity<>(
                userService.AddUser(user),
                HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            return new ResponseEntity<>(
                userService.Login(user),
                HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> signup(@RequestBody User usr) {
        try {
            return new ResponseEntity<>(
                userService.AddUser(usr),
                HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
