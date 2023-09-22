package com.upc.practice.Controller;

import com.upc.practice.Model.CentroReciclaje;
import com.upc.practice.Model.Empresa;
import com.upc.practice.Service.CentroReciclajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centroReciclaje")
public class CentroReciclajeController {
    @Autowired
    public final CentroReciclajeService centroReciclajeService;

    public CentroReciclajeController(CentroReciclajeService centroReciclajeService) {
        this.centroReciclajeService = centroReciclajeService;
    }

    @PostMapping
    public ResponseEntity<CentroReciclaje> insert(@RequestBody CentroReciclaje centroReciclaje){
        return new ResponseEntity<>(centroReciclajeService.insert(centroReciclaje), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CentroReciclaje>> listaCentro(){
        return new ResponseEntity<>(centroReciclajeService.lsCentroReciclaje(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroReciclaje> listaPorID(@PathVariable Long id){
        return new ResponseEntity<>(centroReciclajeService.listaPorID(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CentroReciclaje> modifica(@PathVariable Long id,@RequestBody CentroReciclaje centroReciclaje) throws Exception {
        return new ResponseEntity<>(centroReciclajeService.modifica(id, centroReciclaje), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CentroReciclaje> elimina(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(centroReciclajeService.eliminar(id), HttpStatus.OK);
    }
}
