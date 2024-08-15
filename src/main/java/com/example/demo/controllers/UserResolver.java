package com.example.demo.controllers;


import com.example.demo.entity.PageInfo;
import com.example.demo.entity.UserConnection;
import com.example.demo.entity.UserEdge;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServiceImpl;
import com.example.demo.utility.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserResolver {

    @Autowired
    private UserServiceImpl userService;

    private UserRepository userRepository;

    UserResolver(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @MutationMapping
    public String createUser(@Argument UserEntity user){
        if(!user.getClientSecret().equals(AppConstants.clientSecret) || !user.getClientId().equals(AppConstants.clientId)){
            return "Sorry, Not Valid User!";
        }
        return userService.createUser(user);
    }

    @QueryMapping
    public UserEntity getUserById(@Argument Integer id){
        return userService.getUserById(id);
    }

    @MutationMapping
    public String updateUser(@Argument UserEntity user,@Argument Integer id){
        return userService.updateUser(user,id);
    }

    /*
    Here in case of spring boot graphQL the argument name here must match with what the client
    sends it back.
    Also, not only the argument name must match with what defines in the schema the function
    name should also gets matched.
     */
    @MutationMapping
    public String deleteUser(@Argument Integer id){
        return userService.deleteUser(id);
    }


    @QueryMapping
    public UserConnection users(@Argument Integer first,@Argument String after){
        // Parse the 'after' cursor (if any)
        int offset = after != null ? Integer.parseInt(after) : 0;

        // Create a pageable object with sorting by ID
        Pageable pageable = PageRequest.of(offset / first, first, Sort.by("id").ascending());

        // Get the page of books
        Page<UserEntity> userPage = userRepository.findAll(pageable);

        // Create edges
        List<UserEdge> edges = new ArrayList<>();
        for (UserEntity user : userPage) {
            UserEdge edge = new UserEdge(user, Integer.toString(offset++));
            edges.add(edge);
        }

        // Create page info
        PageInfo pageInfo = new PageInfo(
                userPage.hasNext() ? Integer.toString(offset) : null,
                userPage.hasNext()
        );

        // Return the connection object
        return new UserConnection(edges, pageInfo);
    }


}
