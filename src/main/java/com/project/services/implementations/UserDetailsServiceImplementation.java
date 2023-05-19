package com.project.services.implementations;

import com.project.entities.enums.UserType;
import com.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User.UserBuilder;

import java.util.logging.Logger;

@Service("userDetailsServiceImplementation")
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger logger = Logger.getLogger("Customer detail service: ");

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if(email == null ){
            throw new UsernameNotFoundException("PLese enter your email first!");
        }
        com.project.entities.User user = userRepository.findByEmail(email);

        if(user == null){
            throw  new UsernameNotFoundException("This credentials do not match any in our database!");
        }

        logger.info("Found user: FirstName: " + user.getFirstName() + "LastName: " + user.getLastName());
        UserBuilder builder = User.withUsername(user.getEmail());
        builder.password(user.getPassword());
        if(user.getType() == UserType.ADMIN){
            builder.roles("ADMIN");
        }else{
            builder.roles("CUSTOMER");
        }
        return builder.build();
    }
}
