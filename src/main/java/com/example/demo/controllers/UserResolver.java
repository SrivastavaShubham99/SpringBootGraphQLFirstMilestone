package com.example.demo.controllers;


import com.example.demo.entity.UserEntity;
import com.example.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserResolver {

    @Autowired
    private UserServiceImpl userService;

    @MutationMapping
    public String createUser(@Argument UserEntity user){
        return userService.createUser(user);
    }

    @QueryMapping
    public UserEntity getUserById(@Argument Integer id){
        return userService.getUserById(id);
    }

    @MutationMapping
    public String updateUser(@Argument UserEntity user,@Argument Integer id){
        System.out.println("user id ::::::::::::::::::::::::" + id);
        return userService.updateUser(user,id);
    }

    @MutationMapping
    public String deleteUserById(@Argument Integer userId){
        return userService.deleteUser(userId);
    }


}
