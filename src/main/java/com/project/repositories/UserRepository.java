package com.project.repositories;

import com.project.entities.User;
import java.util.List;

public interface UserRepository{

    public void deleteById(int id);
    public void saveOrUpdateUser(User user);
    public List<User> findAll();
    public User findById(int id);
    public User findByEmailAndPassword(String email, String password);

}
