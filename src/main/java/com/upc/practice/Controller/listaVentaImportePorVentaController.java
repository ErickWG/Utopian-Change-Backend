package com.upc.practice.Controller;

import com.upc.practice.Model.DTO.listaProductoUbicacion;
import com.upc.practice.Model.DTO.listaVentaImportePorVenta;
import com.upc.practice.Service.listaProductoUbicacionService;
import com.upc.practice.Service.listaVentaImportePorVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/VentaImportePorVenta")
public class listaVentaImportePorVentaController {
    @Autowired
    public final listaVentaImportePorVentaService listaVentaImportePorVentaService;

    public listaVentaImportePorVentaController(com.upc.practice.Service.listaVentaImportePorVentaService listaVentaImportePorVentaService) {
        this.listaVentaImportePorVentaService = listaVentaImportePorVentaService;
    }


    @GetMapping
    public ResponseEntity<List<listaVentaImportePorVenta>> listaVentaImportePorVenta(){
        return new ResponseEntity<>(listaVentaImportePorVentaService.listaVentaImportePorVenta(), HttpStatus.OK);
    }
}
