package com.webunimag.eliminatoria.dto.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class SignupRequest {
    private String username;

    private String email;

    private Set<String> role;

    private String password;


}
