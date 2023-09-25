package com.upc.practice.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class listaMaterialesProducto {
    private String nombreProducto;
    private List<String> nombreMaterial;

}
