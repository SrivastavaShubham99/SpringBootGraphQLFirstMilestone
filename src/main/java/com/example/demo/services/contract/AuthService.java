package com.example.demo.services.contract;

import com.example.demo.data.LoginRequest;
import com.example.demo.data.LoginResponse;
import com.example.demo.entity.RegisterEntity;

public interface AuthService {

    public LoginResponse loginUser(LoginRequest loginRequest);
}
