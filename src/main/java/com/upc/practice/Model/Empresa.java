package com.upc.practice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor // Constructor con argumentos
@NoArgsConstructor // Constructor sin argumentos
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresaa;
    private String nombreEmpresa;
    private String ubicacionEmpresa;
    private String detalleEmpresa;
    private String correoEmpresa;
    private String sitioWebEmpresa;
}
