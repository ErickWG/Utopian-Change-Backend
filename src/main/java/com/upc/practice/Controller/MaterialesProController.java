package com.upc.practice.Controller;

import com.upc.practice.Model.DTO.MaterialesPro;
import com.upc.practice.Model.DTO.MaterialesReci;
import com.upc.practice.Service.MaterialesProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materialPro")
public class MaterialesProController {
    @Autowired
    private final MaterialesProService materialesProService;

    public MaterialesProController(MaterialesProService materialesProService) {
        this.materialesProService = materialesProService;
    }


/*    @GetMapping
    public ResponseEntity<MaterialesPro> materialesPro(@RequestParam String nombreMaterial){
        return new ResponseEntity<>(materialesProService.materialesPro(nombreMaterial), HttpStatus.OK);
    }
    @GetMapping("/materialProls")
    public ResponseEntity<List<MaterialesPro>> listamaterialesPro(){
        return new ResponseEntity<>(materialesProService.lsmaterialesPro(), HttpStatus.OK);
    }*/
}
