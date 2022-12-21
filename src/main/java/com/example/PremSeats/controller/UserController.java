package com.example.PremSeats.controller;


import com.example.PremSeats.common.UserConstant;
import com.example.PremSeats.model.Team;
import com.example.PremSeats.model.User;
import com.example.PremSeats.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepo repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    //Register to the website & Encrypt password, and store data
    @PostMapping("/join")
    public void joinGroup(@RequestBody User user) {
        user.setRoles(UserConstant.DEFAULT_ROLE);//USER
        String encryptedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPwd);
        repository.save(user);
    }

    //Spring Security Blocked this page without authorization using basic auth used to log in the user
    @GetMapping("/validate")
    public HttpStatus Validate() {
        return HttpStatus.OK;
    }


    //Get user role
    @PostMapping("/getrole")
    public String GetUser(@RequestBody String auth) {
        String[] AuthData = auth.split(":");

        Optional<User> ExistingUser = repository.findByUserName(AuthData[0]);
        if (ExistingUser.isPresent()) {
            String password = AuthData[1];
            if(ExistingUser.get().getPassword().equals(password)){
                return ExistingUser.get().getRoles();
            }
            return ExistingUser.get().getRoles();
        }

        return null;
    }

    //Get user role
    @PostMapping("/getid")
    public Long GetUserID(@RequestBody String username) {
        Optional<User> ExistingUser = repository.findByUserName(username);
        if (ExistingUser.isPresent()) {
            return ExistingUser.get().getId();
        }
        return null;
    }


    //Find specific user by id
    @GetMapping("/getuser/{id}")
    public User getUserbyId(@PathVariable("id") Long id){
        Optional<User> ExistingUser = repository.findById(id);
            return ExistingUser.get();
    }





    //If logged in user is ADMIN -> can give Admin to other users
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/give/{userId}/{userRole}")
    public ResponseEntity<User> giveAccessToUser(@PathVariable Long userId, @PathVariable String userRole) {
        User user = repository.findById(userId).get();
        user.setRoles(userRole);
        repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //Update users balance
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/setbalance/{userId}/{balance}")
    public ResponseEntity<User> UpdateBalance(@PathVariable Long userId, @PathVariable Double balance) {
        User user = repository.findById(userId).get();
        user.setBalance(balance);
        repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Top up
    @PutMapping("/topup/{userId}/{balance}")
    public ResponseEntity<User> TopUp(@PathVariable Long userId, @PathVariable Double balance) {
        User user = repository.findById(userId).get();
        double currentbal = user.getBalance();
        Double updatedbal = currentbal + balance;
        user.setBalance(updatedbal);
        repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Lower balance
    @PutMapping("/topdown/{userId}/{balance}")
    public ResponseEntity<User> TopDown(@PathVariable Long userId, @PathVariable Double balance) {
        User user = repository.findById(userId).get();
        double currentbal = user.getBalance();
        Double updatedbal = currentbal - balance;
        user.setBalance(updatedbal);
        repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    //Show all registered users
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/allusers")
    public List<User> loadUsers() {
        return repository.findAll();
    }

}
