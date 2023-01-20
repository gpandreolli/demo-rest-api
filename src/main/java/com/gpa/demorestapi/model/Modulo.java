package com.gpa.demorestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Modulo {

    @Id
    public Long id;

    @Column(nullable = false,length = 500)
    public String nome;

    public long getId() {
        return id;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "modulo")
    public List<Ticket> tickets;

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
