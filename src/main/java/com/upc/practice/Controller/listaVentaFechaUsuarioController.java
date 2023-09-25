package com.upc.practice.Controller;

import com.upc.practice.Model.DTO.listaVentaFechaUsuario;
import com.upc.practice.Service.listaVentaFechaUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/listaVentaFechaUsuario")
@EnableMethodSecurity(proxyTargetClass = true)
public class listaVentaFechaUsuarioController {
    private final listaVentaFechaUsuarioService listaVentaFechaUsuarioService;

    public listaVentaFechaUsuarioController(listaVentaFechaUsuarioService listaVentaFechaUsuarioService) {
        this.listaVentaFechaUsuarioService = listaVentaFechaUsuarioService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<listaVentaFechaUsuario>> lsUserFechaVenta(@RequestParam LocalDate fecha){
        return new ResponseEntity<>(listaVentaFechaUsuarioService.lsUserFechaVenta(fecha), HttpStatus.OK);
    }
}
