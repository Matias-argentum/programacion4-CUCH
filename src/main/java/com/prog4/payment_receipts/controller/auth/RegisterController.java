package com.prog4.payment_receipts.controller.auth;

import com.prog4.payment_receipts.dto.auth.RegisterRequestDto;
import com.prog4.payment_receipts.dto.auth.RegisterResponseDto;
import com.prog4.payment_receipts.service.auth.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto request){
        RegisterResponseDto response = registerService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
