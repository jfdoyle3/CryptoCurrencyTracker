package com.cryptocurrency.backend.controllers;

import com.cryptocurrency.backend.entities.ERole;
import com.cryptocurrency.backend.entities.Role;
import com.cryptocurrency.backend.entities.User;
import com.cryptocurrency.backend.payloads.request.LoginRequest;
import com.cryptocurrency.backend.payloads.request.SignupRequest;
import com.cryptocurrency.backend.payloads.response.JwtResponse;
import com.cryptocurrency.backend.payloads.response.MessageResponse;
import com.cryptocurrency.backend.repositories.RoleRepository;
import com.cryptocurrency.backend.repositories.UserRepository;
import com.cryptocurrency.backend.security.jwt.JwtUtils;
import com.cryptocurrency.backend.security.services.UserDetailsImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;
  
    
    @Value("${spring.datasource.driver-class-name}")
    public String myDriver;

    @Value("${spring.datasource.url}")
    public String myUrl;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                                                 userDetails.getId(),
                                                 userDetails.getUsername(),
                                                 roles));
    }

	@PostMapping("/signup")
    @SuppressWarnings("unused")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
    	
    	
    	// TODO roles auto fill not working.
    	int roleCheck=roleRepository.isRoleEmpty();
    	System.out.println(roleCheck);
    	if (roleCheck < ERole.values().length) {
    	    int id = 0;
    	    for (ERole role : ERole.values()) {
    	        if (roleRepository.findByName(role).isEmpty()) {
    	            try {
    	                Connection conn = DriverManager.getConnection(myUrl, "reflect", "whoiam");
    	                Class.forName(myDriver);
    	                String query = "Insert into role (id, name) values (?,?)";
    	                PreparedStatement statement = conn.prepareStatement(query);

    	                statement.setString(1, Integer.toString(++id));
    	                statement.setString(2, role.toString());

    	                statement.executeUpdate();

    	            } catch (Exception e) {
    	                Logger logger = LoggerFactory.getLogger(AuthController.class);
    	                System.out.println(e.getMessage());

    	            }
    	        }
    	    }
    	}
    	
    	
    	//SIGN IN : Check for existing accounts
    	if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email already in use please login or reset password"));
        }

        //SIGN IN: Create New Account
        User user = new User(signupRequest.getUsername(), encoder.encode(signupRequest.getPassword()));
        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        // SIGN IN: ASSIGN ROLE
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch(role) {
                    case "admin":
                    case "administrator":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(adminRole);

                        break;
                    case "mod":
                    case "moderator":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR).orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(userRole);

                        break;
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity<Object>(new MessageResponse("User registered successfully"), HttpStatus.CREATED);
        }

}
