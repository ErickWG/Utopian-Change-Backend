package com.upc.practice.Controller;

import com.upc.practice.Model.DTO.listaCentroReciclajePorDistrito;
import com.upc.practice.Model.DTO.listaProductoUbicacion;
import com.upc.practice.Service.listaProductoUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ProductoBuscarUbicacion")
public class listaProductoUbicacionController {
    @Autowired
    public final listaProductoUbicacionService listaProductoUbicacionService;

    public listaProductoUbicacionController(com.upc.practice.Service.listaProductoUbicacionService listaProductoUbicacionService) {
        this.listaProductoUbicacionService = listaProductoUbicacionService;
    }
    @GetMapping
    public ResponseEntity<List<listaProductoUbicacion>> listarProductoUbicación(@RequestParam String nombreProducto){
        return new ResponseEntity<>(listaProductoUbicacionService.listaProductoUbicacion(nombreProducto), HttpStatus.OK);
    }
}