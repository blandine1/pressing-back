package com.pressing.pressing.dto;

import com.pressing.pressing.entity.Role;

import java.sql.Timestamp;
import java.util.Date;

public class SignUpRequest {
    private String name;
    private String prenom;
    private String email;
    private Date dateDeNaissance;
    private String password;
    private Role role;
}
