package com.pressing.pressing.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String prenom;
    private String email;
    private String password;
}
