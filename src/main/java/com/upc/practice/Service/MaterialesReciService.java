package com.upc.practice.Service;

import com.upc.practice.Model.CentroReciclaje;
import com.upc.practice.Model.DTO.MaterialesPro;
import com.upc.practice.Model.DTO.MaterialesReci;
import com.upc.practice.Model.DTO.listaCentroReciclajePorDistrito;
import com.upc.practice.Model.Material;
import com.upc.practice.Repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Service
public class MaterialesReciService {
    @Autowired
    public final MaterialRepo materialRepo;

    public MaterialesReciService(MaterialRepo materialRepo) {
        this.materialRepo = materialRepo;
    }

    public MaterialesReci materialesReci(String nombreMaterial){
        List<Material> materials=materialRepo.findAll();
        MaterialesReci material;
        material=new MaterialesReci();
        for (Material m:materials){
            if (Objects.equals(nombreMaterial, m.getNombreMaterial())){
                material.setNombreMaterial(m.getNombreMaterial());
                material.setDetalleMaterial(m.getDetalleMaterial());
                material.setPrecio(m.getPrecio());
                material.setNombreCentro(m.getCentroReciclaje().getNombreCentro());
                material.setHorarioCentro(m.getCentroReciclaje().getHorarioCentro());
                material.setUbicacionCentro(m.getCentroReciclaje().getUbicacionCentro());

            }
        }
        return material;
    }
    public List<MaterialesReci> lsmaterialesReci(){
        List<Material> materials=materialRepo.findAll();
        MaterialesReci material;
        List<MaterialesReci> lista=new ArrayList<>();

        for (Material m:materials){
                if (m.getCentroReciclaje()!=null){
                    material=new MaterialesReci();
                    material.setNombreMaterial(m.getNombreMaterial());
                    material.setDetalleMaterial(m.getDetalleMaterial());
                    material.setPrecio(m.getPrecio());
                    material.setNombreCentro(m.getCentroReciclaje().getNombreCentro());
                    material.setHorarioCentro(m.getCentroReciclaje().getHorarioCentro());
                    material.setUbicacionCentro(m.getCentroReciclaje().getUbicacionCentro());
                    lista.add(material);
                    material=null;
                }

        }
        return lista;
    }
}
