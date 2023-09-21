package com.upc.practice.Controller;

import com.upc.practice.Service.CentroReciclajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centroReciclaje")
public class CentroReciclajeController {
    @Autowired
    private final CentroReciclajeService centroReciclajeService;

    public CentroReciclajeController(CentroReciclajeService centroReciclajeService) {
        this.centroReciclajeService = centroReciclajeService;
    }
}
