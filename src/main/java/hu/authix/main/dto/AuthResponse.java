package hu.authix.main.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Authentikáció - Bejelentkezés után adatokat visszaadó DTO.")
public class AuthResponse {
	
	@Schema(description = "Felhasználónév", example = "Kata03")
    private String username;
	
	@Schema(description = "JWT token", example = "eyJhbGci6IkpXVCJ9...")
    private String token;
}

