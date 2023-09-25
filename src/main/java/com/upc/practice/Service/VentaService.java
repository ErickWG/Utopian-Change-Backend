package com.upc.practice.Service;

import com.upc.practice.Model.Material;
import com.upc.practice.Model.Venta;
import com.upc.practice.Repository.VentarRepo;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private final VentarRepo ventarRepo;

    public VentaService(VentarRepo ventarRepo) {
        this.ventarRepo = ventarRepo;
    }
    //Insertar
    public Venta insert (Venta venta){ return ventarRepo.save(venta);}

    //Listar
    public List<Venta> lsVenta(){ return ventarRepo.findAll();}
    //modificar TERMINAR ZZZ
/*    public Venta modifica (Long id, Venta venta) throws Exception{
        Venta v= ventarRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException(("No se encontro el ID" + id)));
        v.s(material.getNombreMaterial());
        v.setDetalleMaterial(material.getDetalleMaterial());
        return materialRepo.save(material);
    }*/

    //Eliminar
    public Venta eliminar(Long id) throws Exception{
        Venta v=ventarRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontro el ID" + id));
        ventarRepo.delete(v);
        return v;
    }
}
