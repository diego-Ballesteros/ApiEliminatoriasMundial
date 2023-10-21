package com.webunimag.eliminatoria.service;

import com.webunimag.eliminatoria.dto.security.JwtResponse;
import com.webunimag.eliminatoria.dto.security.LoginRequest;
import com.webunimag.eliminatoria.dto.security.SignupRequest;
import com.webunimag.eliminatoria.persistence.entity.AutenticationEntity.ERole;
import com.webunimag.eliminatoria.persistence.entity.AutenticationEntity.Role;
import com.webunimag.eliminatoria.persistence.entity.AutenticationEntity.UserEntity;
import com.webunimag.eliminatoria.persistence.repository.RoleRepository;
import com.webunimag.eliminatoria.persistence.repository.UserRepository;
import com.webunimag.eliminatoria.security.jwt.JwtUtils;
import com.webunimag.eliminatoria.security.servicesSecurity.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    public JwtResponse login(LoginRequest login) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateAccestoken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }


    public String signup(SignupRequest signup) {
        if (userRepository.existsByUserName(signup.getUsername())) {
            return "Error: Username is already taken!";
        }

        if (userRepository.existsByEmail(signup.getEmail())) {
            return "Error: Email is already in use!";
        }

        // Create new user's account
        UserEntity user = new UserEntity(signup.getUsername(),
                signup.getEmail(),
                encoder.encode(signup.getPassword()));

        Set<String> strRoles = signup.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return "User registered successfully!";
    }
}
