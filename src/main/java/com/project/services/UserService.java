package com.project.services;

import com.project.dto.UserDTO;
import com.project.entities.User;

import java.util.List;

public interface UserService {

    public String[] getUserHomepage(String mail, String password);
    public UserDTO getUserById(int id);
    public UserDTO getUserByCredentials(String email, String password);
    public List<UserDTO> getAllUsers();
    public String deleteUserById(int deleteID);
    public String saveOrUpdateUser(int userId, int userToChangeId,String firstName, String lastName, String email, String password, String dateString, String type);
}
