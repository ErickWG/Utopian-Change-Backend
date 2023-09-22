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
public class CentroReciclaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCentroReciclaje;
    private String nombreCentro;
    private String ubicacionCentro;
    private String detalleCentro;
    private String horarioCentro;
    private String correoCentro;
    private String sitioWebCentro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    private Material material;
}
