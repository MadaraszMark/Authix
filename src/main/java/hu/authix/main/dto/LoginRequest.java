package hu.authix.main.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
@Schema(description = "Belépéshez szükséges DTO")
public class LoginRequest {

    @NotBlank(message = "A felhasználónév vagy e-mail megadása kötelező")
    @Schema(description = "Felhasználónév vagy E-mail cím")
    private String usernameOrEmail;

    @NotBlank(message = "A jelszó megadása kötelező")
    @Schema(description = "Jelszó")
    private String password;
}
