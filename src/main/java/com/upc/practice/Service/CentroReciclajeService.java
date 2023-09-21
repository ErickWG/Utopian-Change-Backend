package com.upc.practice.Service;

import com.upc.practice.Repository.CentroReciclajeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroReciclajeService {
    @Autowired
    private final CentroReciclajeRepo centroReciclajeRepo;

    public CentroReciclajeService(CentroReciclajeRepo centroReciclajeRepo) {
        this.centroReciclajeRepo = centroReciclajeRepo;
    }
}
