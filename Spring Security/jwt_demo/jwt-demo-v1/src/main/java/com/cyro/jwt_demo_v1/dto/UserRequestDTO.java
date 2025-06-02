package com.cyro.jwt_demo_v1.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String userName;
    private String password;
}
