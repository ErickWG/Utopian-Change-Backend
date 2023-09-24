package com.upc.practice.Service;

import com.upc.practice.Model.DTO.listaProductoUbicacion;
import com.upc.practice.Model.Empresa;
import com.upc.practice.Model.Producto;
import com.upc.practice.Repository.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class listaProductoUbicacionService {
    @Autowired
    public final ProductoRepo productoRepo;

    public listaProductoUbicacionService(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }



    public List<listaProductoUbicacion> listaProductoUbicacion(String nombreProducto){
        List<Producto> productos=productoRepo.findAll();
        List<listaProductoUbicacion> listado= new ArrayList<>();
        listaProductoUbicacion e;
        for (Producto c:productos){
            e= new listaProductoUbicacion();
            e.setNombreProducto(c.getNombreProducto());
            e.setUbicacionEmpresa(c.getEmpresa().getUbicacionEmpresa());
            e.setPrecioProducto(c.getPrecioProducto());
            e.setSitioWebEmpresa(c.getEmpresa().getSitioWebEmpresa());
            if (Objects.equals(e.getNombreProducto(), nombreProducto)){
                listado.add(e);
            }
            e=null;

        }
        return listado;

    }
}
