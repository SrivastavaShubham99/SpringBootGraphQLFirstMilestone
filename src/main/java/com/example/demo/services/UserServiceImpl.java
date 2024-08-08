package com.example.demo.services;


import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.contract.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public String createUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return "User created successfully";
    }

    @Override
    public UserEntity getUserById(Integer id) {
        Optional<UserEntity> user= userRepository.findById(id);
        return user.get();
    }

    @Override
    public String updateUser(UserEntity user,Integer userId) {
        Optional<UserEntity> savedUser=userRepository.findById(userId);
        savedUser.get().setEmail(user.getEmail());
        savedUser.get().setMobile(user.getMobile());
        savedUser.get().setFirstName(user.getFirstName());
        savedUser.get().setLastName(user.getLastName());
        userRepository.save(savedUser.get());
        return "User updated successfully";
    }

    @Override
    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}
