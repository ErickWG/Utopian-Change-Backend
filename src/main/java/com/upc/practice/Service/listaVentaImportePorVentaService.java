package com.upc.practice.Service;

import com.upc.practice.Model.DTO.listaProductoUbicacion;
import com.upc.practice.Model.DTO.listaVentaImportePorVenta;
import com.upc.practice.Model.DetalleVenta;
import com.upc.practice.Model.Producto;
import com.upc.practice.Repository.DetalleVentaRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service

public class listaVentaImportePorVentaService {
    @Autowired

    public final DetalleVentaRepository detalleVentaRepository;

    public listaVentaImportePorVentaService(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    public List<listaVentaImportePorVenta> listaVentaImportePorVenta(Long idVenta){
        List<DetalleVenta> detalleVentas=detalleVentaRepository.findAll();
        List<listaVentaImportePorVenta> listado= new ArrayList<>();
        listaVentaImportePorVenta lv;
        Double importeTotal = 0.0;
        List<String> productos=new ArrayList<>();
        lv= new listaVentaImportePorVenta();
        for (DetalleVenta dv:detalleVentas){

            if (Objects.equals(dv.getVenta().getIdVenta(), idVenta)){
                lv.setIdVenta(idVenta);
                lv.setFechaVenta(dv.getVenta().getFechaVenta());
                lv.setNombreCliente(dv.getVenta().getUser().getNombreUsuario());

                productos.add((String) Hibernate.unproxy(dv.getProducto().getNombreProducto()));
                importeTotal = importeTotal + dv.getProducto().getPrecioProducto() * dv.getCantidadDetalleVenta();

            }
        }
        lv.setListaProductos(productos);
        lv.setImporteTotal(importeTotal);
        listado.add(lv);

        return listado;

    }
}
