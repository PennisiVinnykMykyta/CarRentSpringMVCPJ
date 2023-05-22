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

    public String saveOrUpdateUser(UserDTO userToChange) throws ParseException {
        User user;

        Integer id;

        if(userToChange.getId() == null || userToChange.getId().isEmpty()){
            id = null;
        }else{
             id = Integer.parseInt(userToChange.getId());
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate;
        try{
            birthDate = format.parse(userToChange.getBirthDate());
        }catch (Exception e) {
            return "parsingError";
        }

        String password = passwordEncoder.encode(userToChange.getPassword());

        String type = userToChange.getUserType();

        UserType role;

        if(type.equals("customer")){
            role = UserType.CUSTOMER;
        }else{
            role = UserType.ADMIN;
        }

        user = new User(id,userToChange.getEmail(),password,userToChange.getFirstName(),userToChange.getLastName(),role,birthDate);

        userRepository.saveOrUpdateUser(user);

         return "redirect:/user/homepage";

    }

}
