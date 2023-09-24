package com.upc.practice.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class listaProductoUbicacion {
    private String nombreProducto;
    private String ubicacionEmpresa;
    private String sitioWebEmpresa;
    private double precioProducto;


}
