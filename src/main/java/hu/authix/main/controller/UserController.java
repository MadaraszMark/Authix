package hu.authix.main.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/me")
    public String me(Authentication auth) {
        return "Bejelentkezve: " + auth.getName();
    }
}

