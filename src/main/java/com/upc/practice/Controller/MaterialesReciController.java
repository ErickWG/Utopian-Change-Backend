package com.upc.practice.Controller;

import com.upc.practice.Model.DTO.MaterialesPro;
import com.upc.practice.Model.DTO.MaterialesReci;
import com.upc.practice.Model.DTO.listaVentaImportePorVenta;
import com.upc.practice.Service.MaterialesReciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materialReci")
public class MaterialesReciController {
    @Autowired
    private final MaterialesReciService materialesReciService;

    public MaterialesReciController(MaterialesReciService materialesReciService) {
        this.materialesReciService = materialesReciService;
    }
/*    @GetMapping
    public ResponseEntity<MaterialesReci> materialesReci(@RequestParam String nombreMaterial){
        return new ResponseEntity<>(materialesReciService.materialesReci(nombreMaterial), HttpStatus.OK);

    }
    @GetMapping("/materialRecils")
    public ResponseEntity<List<MaterialesReci>> listamaterialesReci(){
        return new ResponseEntity<>(materialesReciService.lsmaterialesReci(), HttpStatus.OK);
    }*/
}
