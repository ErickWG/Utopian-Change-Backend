package com.upc.practice.Controller;

import com.upc.practice.Model.Resenas;
import com.upc.practice.Service.ResenasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resena")
public class ResenasController {
    @Autowired
    public final ResenasService resenasService;

    public ResenasController(ResenasService resenasService) {
        this.resenasService = resenasService;
    }

    @PostMapping
    public ResponseEntity<Resenas> insert(@RequestBody Resenas resenas)
    {
        return new ResponseEntity<>(resenasService.insert(resenas), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Resenas>> listaResenas(){
        return new ResponseEntity<>(resenasService.lsResena(), HttpStatus.OK);
    }
}
