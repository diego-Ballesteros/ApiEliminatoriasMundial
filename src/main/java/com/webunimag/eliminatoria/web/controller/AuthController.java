package com.webunimag.eliminatoria.web.controller;

import com.webunimag.eliminatoria.dto.security.JwtResponse;
import com.webunimag.eliminatoria.dto.security.LoginRequest;
import com.webunimag.eliminatoria.dto.security.SignupRequest;
import com.webunimag.eliminatoria.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService auth;

    @PostMapping ("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest login){
        System.out.println("login: "+login.getEmail());
        return new ResponseEntity<>(auth.login(login), HttpStatus.OK);
    }
    @PostMapping ("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signup){
        return new ResponseEntity<>(auth.signup(signup), HttpStatus.OK);
    }
}
