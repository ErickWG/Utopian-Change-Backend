package com.upc.practice.Service;

import com.upc.practice.Model.DTO.listaVentaImportePorVenta;
import com.upc.practice.Model.DetalleVenta;
import com.upc.practice.Model.Venta;
import com.upc.practice.Repository.DetalleVentaRepository;
import com.upc.practice.Repository.VentarRepo;
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
    public final VentarRepo ventarRepo;
    public listaVentaImportePorVentaService(DetalleVentaRepository detalleVentaRepository, VentarRepo ventarRepo) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.ventarRepo = ventarRepo;
    }

    public List<listaVentaImportePorVenta> listaVentaImportePorVenta(){
        List<DetalleVenta> detalleVentas=detalleVentaRepository.findAll();
        List<Venta> Ventas=ventarRepo.findAll();
        List<listaVentaImportePorVenta> listado= new ArrayList<>();



        for (Venta vv: Ventas){
            listaVentaImportePorVenta lv = new listaVentaImportePorVenta();
            Double importeTotal = 0.0;
            List<String> productos=new ArrayList<>();

            lv.setIdVenta(vv.getIdVenta());
            lv.setFechaVenta(vv.getFechaVenta());
            lv.setNombreCliente(vv.getUser().getNombreUsuario());
            for (DetalleVenta dv:detalleVentas){

                if (Objects.equals(dv.getVenta().getIdVenta(), lv.getIdVenta())){

                    productos.add((String) Hibernate.unproxy(dv.getProducto().getNombreProducto()));
                    importeTotal = importeTotal + dv.getProducto().getPrecioProducto() * dv.getCantidadDetalleVenta();

                }
            }
            lv.setListaProductos(productos);
            lv.setImporteTotal(importeTotal);
            listado.add(lv);

        }



        return listado;

    }
}
