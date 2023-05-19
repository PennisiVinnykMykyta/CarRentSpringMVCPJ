package com.project.services.implementations;

import com.project.dto.UserDTO;
import com.project.entities.User;
import com.project.entities.enums.UserType;
import com.project.mappers.UserMapper;
import com.project.repositories.UserRepository;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

   @Autowired
   private UserRepository userRepository;
   @Autowired
   private UserMapper userMapper;
   @Autowired
   private PasswordEncoder passwordEncoder;

   @Override
    public String getUserHomepage(String email){
        User user = userRepository.findByEmail(email);

        if(user.getType() == UserType.ADMIN){
            return  "adminHomepage";
        }else{
            return  "customerHomepage";
        }
    }

    @Override
    public UserDTO getUserById(int id){
        User user = userRepository.findById(id);
        return userMapper.fromUserToDto(user);
    }

    @Override
    public UserDTO getUserByCredentials(String mail){
        User user  = userRepository.findByEmail(mail);
        if(user != null){
            return userMapper.fromUserToDto(user);
        }
        return null;
    }

    public List<UserDTO> getAllUsers(){ //CHANGE TO LIST DTO

        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList){
            UserDTO userDTO = userMapper.fromUserToDto(user);
            userDTOList.add(userDTO);
        }
        return  userDTOList;
    }

    public String deleteUserById(int deleteID){

        userRepository.deleteById(deleteID);

        return "userList";
    }

    public String saveOrUpdateUser(int userID, int userToChangeID,String firstName, String lastName, String email, String password, String dateString,String typeUser)
    {
        User user;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        UserType type;
        password = passwordEncoder.encode(password);

        switch (typeUser){
            case "customer":
                type = UserType.CUSTOMER;
                break;

            case "admin":
                type = UserType.ADMIN;
                break;

            default: //if user type is null that means we are changing some details

                if(userID == userToChangeID){//means user is changing info about themselves
                    user = userRepository.findById(userToChangeID);
                    type = user.getType();
                }else{//a user is changing another users info
                    User changeUser = userRepository.findById(userToChangeID);
                    type = changeUser.getType();
                }

                user = new User(userToChangeID,email,password,firstName,lastName,type,date);

                userRepository.saveOrUpdateUser(user);

                user = userRepository.findById(userID);

                if(user.getType() == UserType.ADMIN){
                    return "adminHomepage";
                }else{
                    return "customerHomepage";
                }
        }
        user = new User(email,password,firstName,lastName,type,date);
        userRepository.saveOrUpdateUser(user);

        return "adminHomepage"; //we know it's an admin homepage for sure cos only the admin can add new users
    }

}
