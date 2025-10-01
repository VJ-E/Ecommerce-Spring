package com.ecommerce.service;

import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Trasanctional;
import com.ecommerce.entity.User;
import org.springframework.security.core.userdetails.*;
import org.springframework.security
import org.springframework.crypto.password.PasswordEncoder;


import java.util.Optional;
import javax.management.RuntimeErrorException;

import java.util.List;

@Service
@Trasanctional
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findbyUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers(){
        
    }

    public void deleteUser(Long id){

    }

    public User createUser(User user){
        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("Username is already taken");
        }
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email is already in use");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser){
        User existingUser = userRepository.findById(id).orElseThrow(
            () -> new RuntimeException("User not found")
        );
        
        if(existingUser.getUsername() != updatedUser.getUsername() && userRepository.existsByUsername(existingUser.getUsername())){
            throw new RuntimeException("Username is already Exists");
        }
        if(existingUser.getEmail() != updatedUser.getEmail() && userRepository.existsByEmail(existingUser.getEmail())){
            throw new RuntimeException("Email is already Exists");
        }

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        if(!updatedUser.getPassword().isEmpty()){
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        return userRepository.save(existingUser);
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException{
        User user = userRepository.findByUsernameOrEmail(identifier).orElseThrow(() -> new UsernameNotFoundException("User not found with username or email"));
        return new User(user.getId(),user.getUsername(),user.getEmail(), user.getPassword(),user.getFirstName(),user.getLastName(),user.getPhoneNumber(),user.getRole(),user.getCreatedAt(),user.getUpdatedAt());
    }
}