package com.project.services.implementations;

import com.project.entities.User;
import com.project.repositories.UserRepository;
import com.project.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;
    private User user;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int id){
        user = userRepository.findById(id);
        return user;
    }

    @Override
    public User getUserByCredentials(String mail, String password){
        user  = userRepository.findByEmailAndPassword(mail,password);
        return user;
    }

    public List<User> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return  userList;
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

    public void saveOrUpdateUser(User user){
        userRepository.saveOrUpdateUser(user);
    }


}
