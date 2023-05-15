package com.project.services.implementations;

import com.project.dto.UserDTO;
import com.project.entities.User;
import com.project.entities.enums.UserType;
import com.project.mappers.UserMapper;
import com.project.repositories.UserRepository;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
