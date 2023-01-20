package com.gpa.demorestapi.controller;

import com.gpa.demorestapi.dto.RetornoDTO;
import com.gpa.demorestapi.dto.TicketDTO;
import com.gpa.demorestapi.model.Ticket;
import com.gpa.demorestapi.repository.TicketRepository;
import com.gpa.demorestapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketService service;


    @GetMapping(path = "/api/test-ticket")
    public String listTicketsTest(){
        return "test OK";
    }

    @GetMapping(path = "api/ticket/listar/{mes}/{ano}")
    public RetornoDTO listarTickets(@PathVariable("mes") String mes, @PathVariable("ano") String ano) throws ParseException {
        return service.findAllByMonthAndYear(mes, ano);
    }

    @GetMapping(path ="api/ticket/listar/cliente/{idCliente}" )
    public List<Ticket> listarTicketsCliente(@PathVariable("idCliente") Long idCliente){
        return service.findAllByClient(idCliente);
    }

    @GetMapping(path ="api/ticket/listar/modulo/{idModulo}" )
    public List<Ticket> listarTicketsModulo(@PathVariable("idModulo") Long idModulo){
        return service.findAllByModule(idModulo);
    }


    @PostMapping(path = "/api/ticket/criar")
    public String salvar(@RequestBody TicketDTO ticket) throws ParseException {
        return service.salvar(ticket);
    }


}

