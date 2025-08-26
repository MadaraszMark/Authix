package hu.authix.main.controller;

import hu.authix.main.dto.AuthResponse;
import hu.authix.main.dto.LoginRequest;
import hu.authix.main.dto.RegisterRequest;
import hu.authix.main.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authix API", description = "Egyszerű regisztrációs / bejelentkezős REST API")
@Validated
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Regisztráció",
        responses = {
            @ApiResponse(responseCode = "201", description = "Sikeres regisztráció",
                content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "400", description = "Hibás bemenet"),
            @ApiResponse(responseCode = "409", description = "Felhasználónév vagy e-mail már foglalt")
        })
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(req));
    }

    @PostMapping("/login")
    @Operation(summary = "Bejelentkezés",
        responses = {
            @ApiResponse(responseCode = "200", description = "Sikeres bejelentkezés",
                content = @Content(schema = @Schema(implementation = AuthResponse.class))),
            @ApiResponse(responseCode = "401", description = "Hibás felhasználónév vagy jelszó"),
            @ApiResponse(responseCode = "400", description = "Hibás bemenet")
        })
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest req) {
        return ResponseEntity.ok(authService.login(req));
    }
}


