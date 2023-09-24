package com.upc.practice.Service;

import com.upc.practice.Model.CentroReciclaje;
import com.upc.practice.Model.DTO.listaCentroReciclajePorDistrito;
import com.upc.practice.Repository.CentroReciclajeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class listaCentroReciclajePorDistritoService {
    @Autowired
    private final CentroReciclajeRepo centroReciclajeRepo;

    public listaCentroReciclajePorDistritoService(CentroReciclajeRepo centroReciclajeRepo) {
        this.centroReciclajeRepo = centroReciclajeRepo;
    }


    public List<listaCentroReciclajePorDistrito> listaporDistrito(String distrito){
        List<CentroReciclaje> centroReciclajes=centroReciclajeRepo.findAll();
        List<listaCentroReciclajePorDistrito> listado= new ArrayList<>();
        listaCentroReciclajePorDistrito e;
        for (CentroReciclaje c:centroReciclajes){
            e= new listaCentroReciclajePorDistrito();
            e.setNombreCentro(c.getNombreCentro());
            e.setUbicacionCentro(c.getUbicacionCentro());
            e.setDistrito(c.getDistrito());
            e.setDetalleCentro(c.getDetalleCentro());
            e.setHorarioCentro(c.getHorarioCentro());
            e.setCorreoCentro(c.getCorreoCentro());
            e.setSitioWebCentro(c.getSitioWebCentro());
            if (Objects.equals(e.getDistrito(), distrito)){
                listado.add(e);
            }
            e=null;

        }
        return listado;

    }
}
