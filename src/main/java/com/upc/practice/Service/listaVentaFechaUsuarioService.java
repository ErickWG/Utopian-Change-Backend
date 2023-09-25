package com.upc.practice.Service;

import com.upc.practice.Model.DTO.listaVentaFechaUsuario;
import com.upc.practice.Model.Venta;
import com.upc.practice.Repository.VentarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service

public class listaVentaFechaUsuarioService {
    @Autowired
    private final VentarRepo ventarRepo;

    public listaVentaFechaUsuarioService(VentarRepo ventarRepo) {
        this.ventarRepo = ventarRepo;
    }


    public List<listaVentaFechaUsuario> lsUserFechaVenta(LocalDate fecha){
        List<Venta> lista=ventarRepo.findUsuariosConComprasEnfecha(fecha);
        List<listaVentaFechaUsuario> listaVentaUsuario=new ArrayList<>();
        listaVentaFechaUsuario l;
        for (Venta v:lista){
            l=new listaVentaFechaUsuario();
            l.setUsername(v.getUser().getUsername());
            l.setNombreUsuario(v.getUser().getNombreUsuario());
            l.setApellidoUsuario(v.getUser().getApellidoUsuario());
            l.setIdVenta(v.getIdVenta());
            l.setEstadoVenta(v.getEstadoVenta());
            listaVentaUsuario.add(l);
            l=null;
        }
        return listaVentaUsuario;
    }

}
