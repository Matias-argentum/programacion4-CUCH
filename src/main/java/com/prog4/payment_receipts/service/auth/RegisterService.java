package com.prog4.payment_receipts.service.auth;

import com.prog4.payment_receipts.dto.auth.RegisterRequestDto;
import com.prog4.payment_receipts.dto.auth.RegisterResponseDto;
import com.prog4.payment_receipts.model.user.Role;
import com.prog4.payment_receipts.model.user.User;
import com.prog4.payment_receipts.repository.user.JpaUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public RegisterService(JpaUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponseDto register(RegisterRequestDto request){
        if(userRepository.findByEmail(request.email()).isPresent()){
            throw new IllegalArgumentException("Ya existe un user con ese email en la base de datos.");
        }

        User user = new User();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);
        user.setEnabled(true);

        User saved = userRepository.save(user);

        return new RegisterResponseDto(saved.getId(),
                saved.getEmail(),
                saved.getRole().name());


    }
}
