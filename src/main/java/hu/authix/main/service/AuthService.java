package hu.authix.main.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import hu.authix.main.dto.AuthResponse;
import hu.authix.main.dto.LoginRequest;
import hu.authix.main.dto.RegisterRequest;
import hu.authix.main.mapper.UserMapper;
import hu.authix.main.model.User;
import hu.authix.main.repository.UserRepository;
import hu.authix.main.security.JwtService;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    public AuthResponse register(RegisterRequest req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new IllegalArgumentException("A felhasználónév már foglalt");
        }
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Ez az e-mail cím már használatban van");
        }
        String encoded = passwordEncoder.encode(req.getPassword());
        User saved = userRepository.save(userMapper.toEntity(req, encoded));
        String token = jwtService.generateToken(saved.getUsername());
        return userMapper.toAuthResponse(saved, token);
    }

    public AuthResponse login(LoginRequest req) {
        Optional<User> userOpt = userRepository.findByUsername(req.getUsernameOrEmail())
                .or(() -> userRepository.findByEmail(req.getUsernameOrEmail()));
        User user = userOpt.orElseThrow(() -> new IllegalArgumentException("Hibás felhasználónév vagy jelszó"));
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Hibás felhasználónév vagy jelszó");
        }
        String token = jwtService.generateToken(user.getUsername());
        return userMapper.toAuthResponse(user, token);
    }
}

