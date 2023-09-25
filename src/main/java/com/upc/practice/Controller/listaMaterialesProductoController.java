package com.upc.practice.Controller;

import com.upc.practice.Model.DTO.listaMaterialesProducto;
import com.upc.practice.Model.DTO.listaVentaImportePorVenta;
import com.upc.practice.Service.listaMaterialesProductoService;
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
@RequestMapping("/listaMaterialesProductoPorNombre")
public class listaMaterialesProductoController {
    @Autowired
    public final listaMaterialesProductoService listaMaterialesProductoService;

    public listaMaterialesProductoController(com.upc.practice.Service.listaMaterialesProductoService listaMaterialesProductoService) {
        this.listaMaterialesProductoService = listaMaterialesProductoService;
    }

    @GetMapping
    public ResponseEntity<List<listaMaterialesProducto>> listaMaterialesProductoPorNombre(@RequestParam String nombreProducto){
        return new ResponseEntity<>(listaMaterialesProductoService.listaMaterialesProductos(nombreProducto), HttpStatus.OK);
    }
}
