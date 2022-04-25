package com.magaz2.firstMagaz2.service;

import com.magaz2.firstMagaz2.Entity.User;
import com.magaz2.firstMagaz2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public Optional<User> getUserByLogin(String login){
        return userRepository.findUserByEmail(login);
    }
    public void saveDataUser(User user){
        userRepository.save(user);
    }
}
