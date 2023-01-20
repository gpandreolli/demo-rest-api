package com.gpa.demorestapi.service;

import com.gpa.demorestapi.model.Cliente;
import com.gpa.demorestapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Long id){
        Optional<Cliente> optionalCliente = repository.findById(id);
        if(optionalCliente.isEmpty()){
            throw new IllegalArgumentException("idCliente inválido. Este cliente não existe!");
        }
        return optionalCliente.get();
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }


}
