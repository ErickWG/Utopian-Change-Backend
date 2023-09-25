package com.upc.practice.Service;

import com.upc.practice.Model.User;
import com.upc.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> listarUsuariosUSER(){return userRepository.findUSERS();}
}
