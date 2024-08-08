package com.example.demo.services.contract;

import com.example.demo.entity.UserEntity;

public interface UserService {

    public String createUser(UserEntity userEntity);
    public UserEntity getUserById(Integer id);

    public String updateUser(UserEntity user,Integer userId);

    public String deleteUser(Integer id);

}
