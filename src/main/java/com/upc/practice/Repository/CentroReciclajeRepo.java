package com.upc.practice.Repository;

import com.upc.practice.Model.CentroReciclaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CentroReciclajeRepo extends JpaRepository <CentroReciclaje, Long> {
}
