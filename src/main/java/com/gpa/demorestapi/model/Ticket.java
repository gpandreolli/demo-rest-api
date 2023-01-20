package com.gpa.demorestapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "TITLE",nullable = false, length = 500)
    public String titulo;

    @ManyToOne
    @JoinColumn(name = "FK_ID_CLIENT")
    public Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "FK_ID_MODULE")
    public Modulo modulo;

    @Column(name = "OPENING_DATE")
    @Temporal( TemporalType.DATE)
    public Date dataAbertura;

    @Column(name = "CLOSING_DATE")
    @Temporal( TemporalType.DATE)
    public Date dataEncerramento;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
}
