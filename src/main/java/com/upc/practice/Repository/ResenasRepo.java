package com.upc.practice.Repository;

import com.upc.practice.Model.Resenas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenasRepo extends JpaRepository <Resenas, Long> {
}
