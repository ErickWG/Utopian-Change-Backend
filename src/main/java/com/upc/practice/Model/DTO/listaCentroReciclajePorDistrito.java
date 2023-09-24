package com.upc.practice.Model.DTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class listaCentroReciclajePorDistrito {
    private String nombreCentro;
    private String ubicacionCentro;
    private String distrito;
    private String detalleCentro;
    private String horarioCentro;
    private String correoCentro;
    private String sitioWebCentro;
}
