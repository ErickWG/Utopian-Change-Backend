package com.upc.practice.Service;

import com.upc.practice.Model.Compra;
import com.upc.practice.Repository.CompraRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {
    @Autowired
    private final CompraRepository compraRepository;
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public List<Compra> listar_compra() {
        return compraRepository.findAll();
    }
    public Compra insertar_compra(Compra compra) {
        return compraRepository.save(compra);
    }
    public Compra modificar_compra(Compra compra) {
        Compra comp= compraRepository.findById(compra.getIdCompra())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de compra no existe"));
        return compraRepository.save(compra);
    }
    public Compra eliminar_compra(Compra compra) {
        Compra comp = compraRepository.findById(compra.getIdCompra())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de compra no existe"));
        compraRepository.delete(compra);
        return compra;
    }
}
