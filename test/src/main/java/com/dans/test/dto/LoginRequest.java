package com.dans.test.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequest {

    private String username;
    private String password;
}
