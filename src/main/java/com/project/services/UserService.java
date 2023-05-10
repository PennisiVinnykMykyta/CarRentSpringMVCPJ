package com.project.services;

import com.project.entities.User;

import java.util.List;

public interface UserService {

    public User getUserById(int id);
    public User getUserByCredentials(String email, String password);
    public List<User> getAllUsers();
    public void deleteUserById(int id);
    public void saveOrUpdateUser(User user);
}
