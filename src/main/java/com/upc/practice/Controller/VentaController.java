package com.upc.practice.Controller;

import com.upc.practice.Model.Material;
import com.upc.practice.Model.Venta;
import com.upc.practice.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    public final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }
    @PostMapping
    public ResponseEntity<Venta> insert(@RequestBody Venta venta){
        return new ResponseEntity<>(ventaService.insert(venta), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Venta>> lsVenta(){
        return new ResponseEntity<>(ventaService.lsVenta(), HttpStatus.OK);
    }

/*    @PutMapping("/{id}")
    public ResponseEntity<Material> modifica (@PathVariable Long id,@RequestBody Material material) throws Exception {
        return new ResponseEntity<>(materialService.modifica(id, material), HttpStatus.OK);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Venta> elimina (@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(ventaService.eliminar(id), HttpStatus.OK);
    }
}
