package hu.authix.main.mapper;

import org.springframework.stereotype.Component;
import hu.authix.main.dto.AuthResponse;
import hu.authix.main.dto.RegisterRequest;
import hu.authix.main.model.User;

@Component
public class UserMapper {

    public User toEntity(RegisterRequest req, String encodedPassword) {
        return User.builder()
                .username(req.getUsername())
                .email(req.getEmail())
                .password(encodedPassword)
                .build();
    }

    public AuthResponse toAuthResponse(User user, String token) {
        return AuthResponse.builder()
                .username(user.getUsername())
                .token(token)
                .build();
    }
}

