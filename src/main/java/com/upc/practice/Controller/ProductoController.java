package com.upc.practice.Controller;

import com.upc.practice.Model.Producto;
import com.upc.practice.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    public final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listaProducto(){
        return new ResponseEntity<>(productoService.lsProducto(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listaPorId(@PathVariable Long id){
        return new ResponseEntity<>(productoService.listaPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> insert(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.insert(producto), HttpStatus.CREATED);
    }
    @GetMapping("/buscarentreprecios")
    public ResponseEntity<List<Producto>>buscarProductoEntrePrecios(@RequestParam Double precioMin,@RequestParam Double precioMax){
        return new ResponseEntity<>(productoService.buscarProductoEntrePrecios(precioMin,precioMax), HttpStatus.CREATED);
    }
    @GetMapping("/contarPorEmpresa")
    public ResponseEntity<Map<String,Long>> contarPorEmpresaProducto(Long empresa_id){return new ResponseEntity<>(productoService.ContarProductosPorEmpresa(empresa_id),HttpStatus.OK);}
}
