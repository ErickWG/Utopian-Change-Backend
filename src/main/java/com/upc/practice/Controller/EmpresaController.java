package com.upc.practice.Controller;
import com.upc.practice.Model.Empresa;
import com.upc.practice.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    public final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listaEmpresa(){
        return new ResponseEntity<>(empresaService.lsEmpresa(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> listaPorID(@PathVariable Long id){
        return new ResponseEntity<>(empresaService.listaPorID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empresa> insert(@RequestBody Empresa empresa){
        return new ResponseEntity<>(empresaService.insert(empresa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> modifica(@PathVariable Long id,@RequestBody Empresa empresa) throws Exception {
        return new ResponseEntity<>(empresaService.modifica(id, empresa), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> elimina(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(empresaService.eliminar(id), HttpStatus.OK);
    }
}
