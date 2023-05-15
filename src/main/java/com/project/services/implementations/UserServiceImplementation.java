package com.project.services.implementations;

import com.project.dto.UserDTO;
import com.project.entities.User;
import com.project.entities.enums.UserType;
import com.project.mappers.UserMapper;
import com.project.repositories.UserRepository;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
   private User user;
   private UserDTO userDTO = new UserDTO();

    public String[] getUserHomepage(String email, String password){
        user = userRepository.findByEmailAndPassword(email,password);
        String[] viewAndError = new String[2];

        if(user != null){
            if(user.getType() == UserType.ADMIN){
                viewAndError[0] = "adminHomepage";
            }else{
                viewAndError[0] = "customerHomepage";
            }
            viewAndError[1] = "";
        }else{
            viewAndError[0] = "redirect:/login";
            viewAndError[1] = "Error: these credentials do not match any in our database!";
        }
        return viewAndError;
    }

    @Override
    public UserDTO getUserById(int id){
        user = userRepository.findById(id);
        userDTO = userMapper.fromUserToDto(user);
        return userDTO;
    }

    @Override
    public UserDTO getUserByCredentials(String mail, String password){
        user  = userRepository.findByEmailAndPassword(mail,password);
        if(user != null){
            userDTO = userMapper.fromUserToDto(user);
        }
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){ //CHANGE TO LIST DTO

        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user : userList){
            userDTO = userMapper.fromUserToDto(user);
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

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        UserType type;

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

                userDTO = userMapper.fromUserToDto(user);

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
