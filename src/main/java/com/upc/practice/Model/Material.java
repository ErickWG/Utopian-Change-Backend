package com.upc.practice.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;
    private String detalleMaterial;
    private String nombreMaterial;
    private Double Precio;
/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    private User user;
*/


}
