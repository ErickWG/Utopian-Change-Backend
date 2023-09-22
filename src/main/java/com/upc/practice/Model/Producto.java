package com.upc.practice.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data // Gets y Sets
 // Constructor con argumentos
@NoArgsConstructor // Constructor sin argumentos
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombreProducto;
    private String detalleProducto;
    private double precioProducto;
    private LocalDate fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "producto_material",
            joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_material", referencedColumnName = "id"))
    private List<Material> materials;

    public Producto(String nombreProducto, String detalleProducto, double precioProducto, LocalDate fecha, Empresa empresa, List<Material> materials) {
        this.nombreProducto = nombreProducto;
        this.detalleProducto = detalleProducto;
        this.precioProducto = precioProducto;
        this.fecha = fecha;
        this.empresa = empresa;
        this.materials = materials;
    }
}
