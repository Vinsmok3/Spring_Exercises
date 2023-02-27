package com.develhope.nosqlorm.controllers;

import com.develhope.nosqlorm.entities.User;
import com.develhope.nosqlorm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/count")
    public long count(){
        return userRepository.count();
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable String id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new Exception("User is not found");
        }
    }

    @PutMapping("/{id}")
    public User editUser(@PathVariable String id, @RequestBody  User user) throws Exception{
        if(!userRepository.existsById(id)) throw new Exception("User is not found");
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }

}

