package com.upc.practice.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class listaVentaFechaUsuario {
    private Long idVenta;
    private String estadoVenta;
    private String username;
    private String apellidoUsuario;
    private String nombreUsuario;

}
