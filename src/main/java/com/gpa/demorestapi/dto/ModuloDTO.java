package com.gpa.demorestapi.dto;

public class ModuloDTO {
    public Long id;
    public String nome;
    public Integer qtdeTickets;

    public ModuloDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ModuloDTO(Long id, String nome, Integer qtdeTickets) {
        this.id = id;
        this.nome = nome;
        this.qtdeTickets = qtdeTickets;
    }

    public ModuloDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdeTickets() {
        return qtdeTickets;
    }

    public void setQtdeTickets(Integer qtdeTickets) {
        this.qtdeTickets = qtdeTickets;
    }
}
