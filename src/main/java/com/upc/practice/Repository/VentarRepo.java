package com.upc.practice.Repository;

import com.upc.practice.Model.User;
import com.upc.practice.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface VentarRepo extends JpaRepository<Venta,Long> {
    @Query(value="SELECT * FROM venta v JOIN userutopian u ON u.id_usuario = v.id_venta WHERE v.fecha_venta=?1", nativeQuery = true)
    List<Venta> findUsuariosConComprasEnfecha(LocalDate fecha_venta);

}
