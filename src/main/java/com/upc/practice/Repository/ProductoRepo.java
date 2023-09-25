package com.upc.practice.Repository;

import com.upc.practice.Model.Producto;
import com.upc.practice.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioProductoBetween(Double precioMin, Double precioMax);
    @Query(value = "SELECT count(empresa_id_empresa) from producto where empresa_id_empresa=?1", nativeQuery = true)
    Map<String,Long> ContarProductosPorEmpresa(Long empresa_id);

}
