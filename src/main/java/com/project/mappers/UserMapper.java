package com.project.mappers;


import com.project.dto.UserDTO;
import com.project.entities.User;
import com.project.entities.enums.UserType;
import com.project.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserMapper {

    private UserRepository userRepository;

    public UserMapper(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDTO fromUserToDto(User user){

        int id = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        Date brithDate = user.getBirthDate();
        UserType userType = user.getType();

        UserDTO userDTO = new UserDTO(id,firstName,lastName,email,password,userType,brithDate);

        return userDTO;
    }

    public User fromDtoToUser(UserDTO userDTO){

        int id = userDTO.getId();
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();
        Date brithDate = userDTO.getBirthDate();
        UserType userType = userDTO.getUserType();

        User user = new User(id,firstName,lastName,email,password,userType,brithDate);

        return user;

    }


}
