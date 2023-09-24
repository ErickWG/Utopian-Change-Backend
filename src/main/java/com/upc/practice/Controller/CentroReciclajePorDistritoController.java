package com.upc.practice.Controller;
import com.upc.practice.Model.DTO.listaCentroReciclajePorDistrito;
import com.upc.practice.Service.listaCentroReciclajePorDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/centroReciclajePorDistrito")
public class CentroReciclajePorDistritoController {
    @Autowired
    public final listaCentroReciclajePorDistritoService listaCentroReciclajePorDistritoService;

    public CentroReciclajePorDistritoController(com.upc.practice.Service.listaCentroReciclajePorDistritoService listaCentroReciclajePorDistritoService) {
        this.listaCentroReciclajePorDistritoService = listaCentroReciclajePorDistritoService;
    }
    @GetMapping
    public ResponseEntity<List<listaCentroReciclajePorDistrito>> listaPorDistrito(@RequestParam String distrito){
        return new ResponseEntity<>(listaCentroReciclajePorDistritoService.listaporDistrito(distrito), HttpStatus.OK);
    }
}
