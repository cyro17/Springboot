package com.jwt_demo.jwt_demo.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
