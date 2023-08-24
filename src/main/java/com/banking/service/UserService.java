package com.banking.service;

import com.banking.model.UserInfo;
import com.banking.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfo registerUser(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }
}
