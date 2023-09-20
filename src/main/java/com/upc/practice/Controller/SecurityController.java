package com.upc.practice.Controller;

import com.upc.practice.Model.Security.AuthResponse;
import com.upc.practice.Model.Security.LoginRequest;
import com.upc.practice.Model.Security.RegisterRequest;
import com.upc.practice.Service.SecurityService.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SecurityController {
    private final AuthService authService;
    public SecurityController(AuthService authService) {
        this.authService = authService;
    }
    // Generan un token
    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<AuthResponse> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));

    }
    // Endpoints que requieren autenticación (Token)
    @GetMapping("/api/v1/show")
    public ResponseEntity<String> showDemo () {
        return new ResponseEntity<>("El token funciona correctamente uwu", HttpStatus.OK);
    }
}
