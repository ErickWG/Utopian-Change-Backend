package com.upc.practice.Service;

import com.upc.practice.Model.DetalleVenta;
import com.upc.practice.Repository.DetalleVentaRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {
    @Autowired
    private final DetalleVentaRepository detalleVentaRepository;
    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    public List<DetalleVenta> listar_detalleVenta() {
        return detalleVentaRepository.findAll();
    }
    public DetalleVenta insertar_detalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }
    public DetalleVenta modificar_detalleVenta(DetalleVenta detalleVenta) {
        DetalleVenta detVenta= detalleVentaRepository.findById(detalleVenta.getIdDetalleVenta())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de detalle venta no existe"));
        return detalleVentaRepository.save(detalleVenta);
    }
    public DetalleVenta eliminar_detalleVenta(DetalleVenta detalleVenta) {
        DetalleVenta detVenta = detalleVentaRepository.findById(detalleVenta.getIdDetalleVenta())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de detalle venta no existe"));
        detalleVentaRepository.delete(detalleVenta);
        return detalleVenta;
    }
}
