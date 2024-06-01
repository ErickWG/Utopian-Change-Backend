package com.upc.practice.Service;

import com.upc.practice.Model.Material;
import com.upc.practice.Model.Producto;
import com.upc.practice.Repository.ProductoRepo;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ProductoService {
    @Autowired
    private final ProductoRepo productoRepo;

    public ProductoService(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }
    public List<Producto> lsProducto(){return productoRepo.findAll();}

    public Producto insert(Producto producto){ return productoRepo.save(producto);}

    public Producto listaPorId(Long id){
        return productoRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No existe registro con ese ID = "+id));
    }
    public List<Producto>buscarProductoEntrePrecios(Double precioMin, Double precioMax){
        return productoRepo.findByPrecioProductoBetween(precioMin,precioMax);
    }
    public Map<String,Long>ContarProductosPorEmpresa(Long empresa_id){return productoRepo.ContarProductosPorEmpresa(empresa_id);}
    public Producto eliminar(Long id) throws Exception{
        Producto p=productoRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontro el ID" + id));
        productoRepo.delete(p);
        return p;
    }
}
