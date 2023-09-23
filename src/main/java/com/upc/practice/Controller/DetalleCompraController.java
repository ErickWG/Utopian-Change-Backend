package com.upc.practice.Controller;

import com.upc.practice.Model.DetalleCompra;
import com.upc.practice.Service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/DetalleCompra")
public class DetalleCompraController {
    public final DetalleCompraService detalleCompraService;
    public DetalleCompraController(DetalleCompraService detalleCompraService){
        this.detalleCompraService=detalleCompraService;
    }

    @GetMapping//Listar
    public ResponseEntity<List<DetalleCompra>> listDetaCompra(){
        return new ResponseEntity<>(detalleCompraService.listarDetalleCompra(), HttpStatus.OK);
    }
    @PostMapping//Insertar
    public ResponseEntity<DetalleCompra> inseDetaCompra(@RequestBody DetalleCompra detalleCompra){
        return new ResponseEntity<>(detalleCompraService.insertarDetalleCompra(detalleCompra), HttpStatus.CREATED);
    }
    @PutMapping//Modificar
    public ResponseEntity<DetalleCompra> modiDetaCompra(@RequestBody DetalleCompra detalleCompra){
        return new ResponseEntity<>(detalleCompraService.modificarDetalleCompra(detalleCompra), HttpStatus.OK);
    }
    @DeleteMapping//Eliminar
    public ResponseEntity<DetalleCompra> elimDetaCompra(@RequestBody DetalleCompra detalleCompra){
        return new ResponseEntity<>(detalleCompraService.eliminarDetalleCompra(detalleCompra), HttpStatus.OK);
    }
}
