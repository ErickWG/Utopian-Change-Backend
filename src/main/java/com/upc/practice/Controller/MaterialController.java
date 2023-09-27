package com.upc.practice.Controller;

import com.upc.practice.Model.Empresa;
import com.upc.practice.Model.Material;
import com.upc.practice.Service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    public final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }
    @PostMapping
    public ResponseEntity<Material> insert(@RequestBody Material material){
        return new ResponseEntity<>(materialService.insert(material), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Material>> listaMaterial(){
        return new ResponseEntity<>(materialService.lsMaterial(), HttpStatus.OK);
    }
    @GetMapping("/listPorNombre")
    public ResponseEntity<Material> listaMaterialPorNombre(@RequestParam String nombreMaterial){
        return new ResponseEntity<>(materialService.listarPorNombre(nombreMaterial), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> modifica (@PathVariable Long id,@RequestBody Material material) throws Exception {
        return new ResponseEntity<>(materialService.modifica(id, material), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Material> elimina (@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(materialService.eliminar(id), HttpStatus.OK);
    }

}
