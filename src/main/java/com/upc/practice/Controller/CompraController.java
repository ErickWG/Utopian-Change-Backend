package com.upc.practice.Controller;

import com.upc.practice.Model.Compra;
import com.upc.practice.Service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Compra")
public class CompraController {
    @Autowired
    public final CompraService compraService;
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listar_comp() {
        return new ResponseEntity<>(compraService.listar_compra(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Compra> insertar_comp(@RequestBody Compra compra) {
        return new ResponseEntity<>(compraService.insertar_compra(compra), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Compra> modificar_comp(@RequestBody Compra compra) {
        return new ResponseEntity<>(compraService.modificar_compra(compra), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Compra> eliminar_comp(@RequestBody Compra compra) {
        return new ResponseEntity<>(compraService.eliminar_compra(compra), HttpStatus.OK);
    }
}