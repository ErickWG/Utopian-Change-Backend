package com.upc.practice.Service;

import com.upc.practice.Model.Resenas;
import com.upc.practice.Repository.ResenasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenasService {
    @Autowired
    private final ResenasRepo resenasRepo;

    public ResenasService(ResenasRepo resenasRepo) {
        this.resenasRepo = resenasRepo;
    }

    //insertar reseña
    public Resenas insert (Resenas resenas){ return resenasRepo.save(resenas);}

    //listar
    public List<Resenas> lsResena(){ return resenasRepo.findAll();}



}
