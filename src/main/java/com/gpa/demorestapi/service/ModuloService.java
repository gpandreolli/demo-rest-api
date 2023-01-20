package com.gpa.demorestapi.service;

import com.gpa.demorestapi.model.Cliente;
import com.gpa.demorestapi.model.Modulo;
import com.gpa.demorestapi.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    ModuloRepository repository;

    public Modulo findById(Long id){
        Optional<Modulo> optionalModulo = repository.findById(id);
        if(optionalModulo.isEmpty()){
            throw new IllegalArgumentException("idModulo inválido. Este módulo não existe!");
        }
        return optionalModulo.get();
    }

    public List<Modulo> findAll(){
        return repository.findAll();
    }
}
