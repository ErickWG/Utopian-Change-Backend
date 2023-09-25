package com.upc.practice.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialesReci {
    private String detalleMaterial;
    private String nombreMaterial;
    private Double Precio;
    private String nombreCentro;
    private String ubicacionCentro;
    private String horarioCentro;

}
