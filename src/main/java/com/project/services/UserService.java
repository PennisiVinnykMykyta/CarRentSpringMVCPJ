package com.project.services;

import com.project.dto.UserDTO;
import com.project.entities.User;

import java.util.List;

public interface UserService {

    public String[] getUserHomepage(String mail, String password);
    public UserDTO getUserById(int id);
    public UserDTO getUserByCredentials(String email, String password);
    public List<User> getAllUsers();
    public void deleteUserById(int id);
    public void saveOrUpdateUser(User user);
}
