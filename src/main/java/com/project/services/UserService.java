package com.project.services;

import com.project.dto.UserDTO;
import com.project.entities.User;

import java.text.ParseException;
import java.util.List;

public interface UserService {

    String getUserHomepage(String mail);
    UserDTO getUserById(int id);
    UserDTO getUserByCredentials(String email);
    List<UserDTO> getAllUsers();
    String deleteUserById(int deleteID);

    String saveOrUpdateUser(UserDTO userDTO) throws ParseException;
}
