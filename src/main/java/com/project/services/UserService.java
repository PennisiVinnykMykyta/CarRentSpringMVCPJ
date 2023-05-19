package com.project.services;

import com.project.dto.UserDTO;
import com.project.entities.User;

import java.util.List;

public interface UserService {

    String getUserHomepage(String mail);
    UserDTO getUserById(int id);
    UserDTO getUserByCredentials(String email);
    List<UserDTO> getAllUsers();
    String deleteUserById(int deleteID);
    String saveOrUpdateUser(int userId, int userToChangeId,String firstName, String lastName, String email, String password, String dateString, String type);
}
