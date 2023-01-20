package com.gpa.demorestapi.dto;

import com.gpa.demorestapi.model.Ticket;

import java.util.List;

public class RetornoDTO {

    public String mensagem;
    public List<Ticket> listaDeTickets;
    public List<ClienteDTO> ticketsPorCliente;
    public List<ModuloDTO> ticktesPorModulo;

    public RetornoDTO(String mensagem, List<Ticket> listaDeTickets,
                      List<ClienteDTO> ticketsPorCliente, List<ModuloDTO> ticktesPorModulo) {
        this.mensagem = mensagem;
        this.listaDeTickets = listaDeTickets;
        this.ticketsPorCliente = ticketsPorCliente;
        this.ticktesPorModulo = ticktesPorModulo;
    }

    public RetornoDTO() {
    }

    public List<Ticket> getListaDeTickets() {
        return listaDeTickets;
    }

    public void setListaDeTickets(List<Ticket> listaDeTickets) {
        this.listaDeTickets = listaDeTickets;
    }

    public List<ClienteDTO> getTicketsPorCliente() {
        return ticketsPorCliente;
    }

    public void setTicketsPorCliente(List<ClienteDTO> ticketsPorCliente) {
        this.ticketsPorCliente = ticketsPorCliente;
    }

    public List<ModuloDTO> getTicktesPorModulo() {
        return ticktesPorModulo;
    }

    public void setTicktesPorModulo(List<ModuloDTO> ticktesPorModulo) {
        this.ticktesPorModulo = ticktesPorModulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
