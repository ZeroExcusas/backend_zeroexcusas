package com.zeroexcusas.zeroexcusas_app.service;

import com.zeroexcusas.zeroexcusas_app.model.User;
import com.zeroexcusas.zeroexcusas_app.model.UserDto;
import com.zeroexcusas.zeroexcusas_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                                                                      new ArrayList<>());
    }

    public User save(User user) {
        User newUser = new User();
        newUser.setFirstname( user.getFirstname() );
        newUser.setLastname( user.getLastname() );
        newUser.setDatecreated( LocalDateTime.now() );
        newUser.setBirthday( LocalDateTime.now() );
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.set_gender( user.get_gender() );
        return userRepository.save(newUser);
    }
}
