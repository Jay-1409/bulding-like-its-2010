package com.ticketb.ticketb.services;

import com.ticketb.ticketb.entities.User;
import com.ticketb.ticketb.repositorys.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User AddUser(User user) {
        return userRepo.save(user);
    }

    public User GetUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public void DeleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public User UpdateUser(Long id, User user) {
        User existingUser = userRepo.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            return userRepo.save(existingUser);
        }
        return null;
    }
}
