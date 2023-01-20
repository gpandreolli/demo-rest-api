package com.gpa.demorestapi.dto;

import com.gpa.demorestapi.model.Cliente;
import com.gpa.demorestapi.model.Modulo;
import jakarta.persistence.*;

import java.util.Date;

public class TicketDTO {


    public Long id;

    public String titulo;

    public Long idCliente;

    public Long idModulo;

    public TicketDTO(Long id, String titulo, Long idCliente, Long idModulo) {
        this.id = id;
        this.titulo = titulo;
        this.idCliente = idCliente;
        this.idModulo = idModulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Long idModulo) {
        this.idModulo = idModulo;
    }
}
