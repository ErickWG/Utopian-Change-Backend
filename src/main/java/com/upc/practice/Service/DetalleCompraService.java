package com.upc.practice.Service;

import com.upc.practice.Model.DetalleCompra;
import com.upc.practice.Repository.DetalleCompraRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetalleCompraService {
    @Autowired
    private final DetalleCompraRepository detalleCompraRepository;
    public DetalleCompraService(DetalleCompraRepository detalleCompraRepository){
        this.detalleCompraRepository=detalleCompraRepository;
    }

    //LISTAR detalles de compra
    public List<DetalleCompra> listarDetalleCompra(){
        return detalleCompraRepository.findAll();
    }
    //INSERTAR detalles de compra
    public DetalleCompra insertarDetalleCompra (DetalleCompra detalleCompra){
        return detalleCompraRepository.save(detalleCompra);
    }
    //MODIFICAR detalle de compra
    public DetalleCompra modificarDetalleCompra (DetalleCompra detalleCompra){
        DetalleCompra detaCompra= detalleCompraRepository.findById(detalleCompra.getIdDetalleCompra())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe el ID de ese detalle de compra"));
        return detalleCompraRepository.save(detalleCompra);
    }
    //ELIMINAR detalle de compra
    public DetalleCompra eliminarDetalleCompra (DetalleCompra detalleCompra){
        DetalleCompra detaCompra= detalleCompraRepository.findById(detalleCompra.getIdDetalleCompra())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("No existe el ID de ese detalle de compra"));
        detalleCompraRepository.delete(detalleCompra);
        return detalleCompra;
    }
}
