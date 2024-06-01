package com.upc.practice.Service;

import com.upc.practice.Model.DTO.MaterialesPro;
import com.upc.practice.Model.DTO.MaterialesReci;
import com.upc.practice.Model.Material;
import com.upc.practice.Repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class MaterialesProService {
    @Autowired
    public final MaterialRepo materialRepo;
    public MaterialesProService(MaterialRepo materialRepo) {
        this.materialRepo = materialRepo;
    }
/*    public MaterialesPro materialesPro(String nombreMaterial){
        List<Material> materials=materialRepo.findAll();
        MaterialesPro material;
        material=new MaterialesPro();
        for (Material m:materials){
            if (Objects.equals(nombreMaterial, m.getNombreMaterial())){
                if (m.getCentroReciclaje()==null){
                    material.setNombreMaterial(m.getNombreMaterial());
                    material.setDetalleMaterial(m.getDetalleMaterial());
                }
                else{
                    throw new RuntimeException("El centro de reciclaje del material " + m.getNombreMaterial() + " es null");
                }
            }
        }
        return material;
    }*/
/*    public List<MaterialesPro> lsmaterialesPro(){
        List<Material> materials=materialRepo.findAll();
        MaterialesPro material;
        List<MaterialesPro> lista=new ArrayList<>();
        for (Material m:materials){
                if (m.getCentroReciclaje()==null){
                    material=new MaterialesPro();
                    material.setNombreMaterial(m.getNombreMaterial());
                    material.setDetalleMaterial(m.getDetalleMaterial());
                    lista.add(material);
                    material=null;
                }

        }
        return lista;
    }*/
}
