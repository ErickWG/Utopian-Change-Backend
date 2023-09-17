package com.upc.practice.Service;


import com.upc.practice.Model.Empresa;
import com.upc.practice.Repository.EmpresaRepo;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private final EmpresaRepo empresaRepo;

    public EmpresaService(EmpresaRepo empresaRepo) {
        this.empresaRepo = empresaRepo;
    }
    // Lista de las empresas registradas
    public List<Empresa> lsEmpresa(){ return empresaRepo.findAll();}

    // Agregar una empresa a la lista
    public Empresa insert(Empresa empresa){return empresaRepo.save(empresa);}

    // Busca por ID
    public Empresa listaPorID(Long id){
        return empresaRepo.findById(id).orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registor con ese ID"));
    }

    public Empresa modifica(Long id, Empresa empresa) throws Exception{
        Empresa t = empresaRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontro el ID" + id));
        // PARA QUE NO SE CREE OTRO REGISTRO YA QUE ESTAS MODIFICANDO EN BASE AL ID
        t.setNombreEmpresa(empresa.getNombreEmpresa());
        t.setUbicacionEmpresa(empresa.getUbicacionEmpresa());
        t.setDetalleEmpresa(empresa.getDetalleEmpresa());
        t.setCorreoEmpresa(empresa.getCorreoEmpresa());
        t.setSitioWebEmpresa(empresa.getSitioWebEmpresa());
        return empresaRepo.save(empresa);
    }

    public Empresa eliminar(Long id) throws Exception{
        Empresa t = empresaRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontro el ID" + id));
        empresaRepo.delete(t);
        return t;
    }
}
