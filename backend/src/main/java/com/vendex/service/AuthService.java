package com.vendex.service;

import com.vendex.dto.LoginRequest;
import com.vendex.dto.LoginResponse;
import com.vendex.entity.Tenant;
import com.vendex.entity.User;
import com.vendex.repository.TenantRepository;
import com.vendex.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(LoginRequest request) {
        log.info("Login attempt for user: {}", request.getEmail());

        // Find tenant by domain
        Optional<Tenant> tenant = tenantRepository.findByDomain(request.getDomain());
        if (tenant.isEmpty()) {
            log.warn("Tenant not found for domain: {}", request.getDomain());
            throw new RuntimeException("Tenant not found");
        }

        // Find user by email and tenant
        Optional<User> user = userRepository.findByTenantIdAndEmail(
            tenant.get().getId(),
            request.getEmail()
        );

        if (user.isEmpty()) {
            log.warn("User not found: {}", request.getEmail());
            throw new RuntimeException("Invalid credentials");
        }

        // Verify password
        if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            log.warn("Invalid password for user: {}", request.getEmail());
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        String token = jwtTokenProvider.generateToken(user.get().getId(), tenant.get().getId());

        log.info("User logged in successfully: {}", request.getEmail());

        return new LoginResponse(
            token,
            user.get().getId(),
            user.get().getEmail(),
            user.get().getFirstName(),
            user.get().getLastName(),
            user.get().getRole()
        );
    }
}
