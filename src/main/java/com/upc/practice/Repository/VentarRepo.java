package com.upc.practice.Repository;

import com.upc.practice.Model.User;
import com.upc.practice.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VentarRepo extends JpaRepository<Venta,Long> {

}
