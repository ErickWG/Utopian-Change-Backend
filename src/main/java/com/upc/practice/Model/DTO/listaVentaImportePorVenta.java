package com.upc.practice.Model.DTO;

import com.upc.practice.Model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class listaVentaImportePorVenta {

    private Long idVenta;
    private String nombreCliente;
    private List<String> listaProductos;
    private Double importeTotal;
    private LocalDate fechaVenta;

}
