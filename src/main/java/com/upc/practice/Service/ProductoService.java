package com.upc.practice.Service;

import com.upc.practice.Model.Producto;
import com.upc.practice.Repository.ProductoRepo;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
