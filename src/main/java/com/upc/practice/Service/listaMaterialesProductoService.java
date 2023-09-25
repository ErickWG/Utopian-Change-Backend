package com.upc.practice.Service;

import com.upc.practice.Model.DTO.listaMaterialesProducto;
import com.upc.practice.Model.DTO.listaProductoUbicacion;
import com.upc.practice.Model.Material;
import com.upc.practice.Model.Producto;
import com.upc.practice.Repository.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class listaMaterialesProductoService {
    @Autowired
    private final ProductoRepo productoRepo;

    public listaMaterialesProductoService(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }




    public List<listaMaterialesProducto> listaMaterialesProductos(String nombreProducto){
        List<Producto> productos=productoRepo.findAll();
        List<listaMaterialesProducto> listado= new ArrayList<>();
        listaMaterialesProducto e;
        List<String>nombresMateriales=new ArrayList<>();
        for (Producto c:productos){
            if (Objects.equals(c.getNombreProducto(), nombreProducto)){
                e= new listaMaterialesProducto();
                e.setNombreProducto(c.getNombreProducto());
                // Recuperamos los materiales asociados al producto
                for (Material m:c.getMaterials()){
                    nombresMateriales.add(m.getNombreMaterial());
                }
                e.setNombreMaterial(nombresMateriales);
                listado.add(e);
            }
        }
        return listado;
    }
}
