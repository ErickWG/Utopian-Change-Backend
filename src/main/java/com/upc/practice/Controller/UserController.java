package com.upc.practice.Controller;

import com.upc.practice.Model.Producto;
import com.upc.practice.Model.User;
import com.upc.practice.Model.Venta;
import com.upc.practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@EnableMethodSecurity(proxyTargetClass = true)
public class UserController {
    @Autowired
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<User>> lsUSERS(){
        return new ResponseEntity<>(userService.listarUsuariosUSER(), HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<Optional<User>> buscarPorUsername(@PathVariable String username){
      return new ResponseEntity<>(userService.buscarPorUsername(username), HttpStatus.OK);
    }

}
