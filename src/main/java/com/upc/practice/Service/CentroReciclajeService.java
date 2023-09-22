package com.upc.practice.Service;

import com.upc.practice.Model.CentroReciclaje;
import com.upc.practice.Model.Empresa;
import com.upc.practice.Repository.CentroReciclajeRepo;
import com.upc.practice.Repository.EmpresaRepo;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroReciclajeService {
    @Autowired
    private final CentroReciclajeRepo centroReciclajeRepo;

    public CentroReciclajeService(CentroReciclajeRepo centroReciclajeRepo) {
        this.centroReciclajeRepo = centroReciclajeRepo;
    }

    // Lista de las Centros de reciclajes registradas
    public List<CentroReciclaje> lsCentroReciclaje(){ return centroReciclajeRepo.findAll();}

    // Agregar una Centro de reciclajesa la lista
    public CentroReciclaje insert(CentroReciclaje centroReciclaje){return centroReciclajeRepo.save(centroReciclaje);}

    // Busca por ID
    public CentroReciclaje listaPorID(Long id){
        return centroReciclajeRepo.findById(id).orElseThrow(()-> new OpenApiResourceNotFoundException("No existe registro con ese ID"));
    }

    public CentroReciclaje modifica(Long id, CentroReciclaje centroReciclaje) throws Exception{
        CentroReciclaje c = centroReciclajeRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontro el ID" + id));
        // PARA QUE NO SE CREE OTRO REGISTRO YA QUE ESTAS MODIFICANDO EN BASE AL ID
        c.setNombreCentro(centroReciclaje.getNombreCentro());
        c.setDetalleCentro(centroReciclaje.getDetalleCentro());
        c.setUbicacionCentro(centroReciclaje.getUbicacionCentro());
        c.setHorarioCentro(centroReciclaje.getHorarioCentro());
        c.setCorreoCentro(centroReciclaje.getCorreoCentro());
        c.setSitioWebCentro(centroReciclaje.getSitioWebCentro());
        return centroReciclajeRepo.save(centroReciclaje);
    }

    public CentroReciclaje eliminar(Long id) throws Exception{
        CentroReciclaje c = centroReciclajeRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontro el ID" + id));
        centroReciclajeRepo.delete(c);
        return c;
    }

}
