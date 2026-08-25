package com.prog4.payment_receipts.controller.auth;

import com.prog4.payment_receipts.dto.auth.LoginRequestDto;
import com.prog4.payment_receipts.dto.auth.LoginResponseDto;
import com.prog4.payment_receipts.model.user.User;
import com.prog4.payment_receipts.service.auth.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return new LoginResponseDto(token, user.getEmail(), user.getRole().name());
    }
}