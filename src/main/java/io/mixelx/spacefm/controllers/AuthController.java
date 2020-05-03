package io.mixelx.spacefm.controllers;

import io.mixelx.spacefm.dto.auth.AuthenticationRequest;
import io.mixelx.spacefm.dto.auth.AuthenticationResponse;
import io.mixelx.spacefm.dto.users.SignUpUserDto;
import io.mixelx.spacefm.services.UserService;
import io.mixelx.spacefm.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static io.mixelx.spacefm.utils.Constants.USER_DETAILS_SERVICE;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier(value = USER_DETAILS_SERVICE)
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String jwt = JwtUtils.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody @Valid final SignUpUserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok("OK");
    }

}
