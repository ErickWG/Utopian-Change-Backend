package com.upc.practice.Controller;

import com.upc.practice.Model.DetalleVenta;
import com.upc.practice.Service.DetalleVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DetalleVenta")
@CrossOrigin(origins = "http://localhost:4200")

public class DetalleVentaController {
    public final DetalleVentaService detalleVentaService;
    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listar_detVenta() {
        return new ResponseEntity<>(detalleVentaService.listar_detalleVenta(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DetalleVenta> insertar_detVenta(@RequestBody DetalleVenta detalleVenta) {
        return new ResponseEntity<>(detalleVentaService.insertar_detalleVenta(detalleVenta), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<DetalleVenta> modificar_detVenta(@RequestBody DetalleVenta detalleVenta) {
        return new ResponseEntity<>(detalleVentaService.modificar_detalleVenta(detalleVenta), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<DetalleVenta> eliminar_detVenta(@RequestBody DetalleVenta detalleVenta) {
        return new ResponseEntity<>(detalleVentaService.eliminar_detalleVenta(detalleVenta), HttpStatus.OK);
    }
}
