package com.gpa.demorestapi.service;

import com.gpa.demorestapi.dto.*;
import com.gpa.demorestapi.model.Cliente;
import com.gpa.demorestapi.model.Modulo;
import com.gpa.demorestapi.model.Ticket;
import com.gpa.demorestapi.repository.ClienteRepository;
import com.gpa.demorestapi.repository.TicketRepository;
import com.gpa.demorestapi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModuloService moduloService;



    public RetornoDTO findAllByMonthAndYear(String mes, String ano) throws ParseException {

        RetornoDTO retorno = new RetornoDTO();
        retorno.ticketsPorCliente = new ArrayList<>();
        retorno.ticktesPorModulo = new ArrayList<>();
        retorno.listaDeTickets = new ArrayList<>();
       try{
           if(Integer.parseInt(mes) <1 || Integer.parseInt(mes)>12){
               throw new IllegalArgumentException("Mês invalido! Preencha com valor entre 1 e 12");
           }
           Date dataFinal = Util.encontraDataFinal(mes,ano);
           Date dataInicial =  Util.encontraDataInicial(mes,ano);
           List<Ticket> listaTickets = repository.findAllbyMonthAndYear(dataInicial, dataFinal);

           List<Cliente> listaClientes = clienteService.findAll();
           List<Modulo> listaModulos = moduloService.findAll();

           List<ClienteDTO> listaClientesDTO = new ArrayList<>();
           List<ModuloDTO> listaModulosDTO = new ArrayList<>();

           int qtdeTicketsModulos = 0;
           int qtdeTicketsClientes = 0;

           for (Cliente cliente: listaClientes ) {
               ClienteDTO clienteDTO = new ClienteDTO();
               qtdeTicketsClientes = 0;
               for (Ticket ticket: listaTickets) {
                   if(cliente.getId() == ticket.getCliente().getId()){
                       clienteDTO.setNome(ticket.getCliente().getNome());
                       clienteDTO.setId(ticket.getCliente().getId());
                       qtdeTicketsClientes++;
                   }
               }
               clienteDTO.setQtdeTickets(qtdeTicketsClientes);
               if(qtdeTicketsClientes == 0){
                   clienteDTO.setId(cliente.getId());
                   clienteDTO.setNome(cliente.getNome());
               }
               listaClientesDTO.add(clienteDTO);
           }

           for (Modulo modulo: listaModulos) {
               ModuloDTO moduloDTO = new ModuloDTO();
               qtdeTicketsModulos = 0;
               for (Ticket ticket: listaTickets ) {
                   if(modulo.getId() == ticket.getModulo().getId()){
                       moduloDTO.setNome(ticket.getModulo().getNome());
                       moduloDTO.setId(ticket.getModulo().getId());
                       qtdeTicketsModulos++;
                   }
               }
               moduloDTO.setQtdeTickets(qtdeTicketsModulos);
               if(qtdeTicketsModulos == 0){
                   moduloDTO.setId(modulo.getId());
                   moduloDTO.setNome(modulo.getNome());
               }
               listaModulosDTO.add(moduloDTO);
           }

           retorno.setMensagem("Sucesso");
           retorno.setListaDeTickets(listaTickets);
           retorno.setTicketsPorCliente(listaClientesDTO);
           retorno.setTicktesPorModulo(listaModulosDTO);

           return retorno;

       }catch (IllegalArgumentException e){
           e.printStackTrace();
           retorno.setMensagem(e.getMessage());
           return retorno;
       }

    }

    public List<Ticket> findAllByClient(Long idCliente){

        List<Ticket> listaTicketsCliente = new ArrayList<>();
        List<Ticket> listaAuxiliar;
          try{
              listaAuxiliar = repository.findAll();
              if(listaAuxiliar.isEmpty()){
                  throw new IllegalArgumentException("Não existem tickets a serem mostrados!");
              }
              for (Ticket ticket: listaAuxiliar) {
                  if(ticket.getCliente().getId() == idCliente){
                      listaTicketsCliente.add(ticket);
                  }
              }
              if(listaTicketsCliente.isEmpty()){
                  throw new IllegalArgumentException("Não existem tickets deste cliente a serem mostrados!");
              }
              return  listaTicketsCliente;


          }catch (IllegalArgumentException e){
              return  listaTicketsCliente;
          }

    }

    public List<Ticket> findAllByModule(Long idModulo){

        List<Ticket> listaTicketsModulo = new ArrayList<>();
        List<Ticket> listaAuxiliar;
        try{
            listaAuxiliar = repository.findAll();
            if(listaAuxiliar.isEmpty()){
                throw new IllegalArgumentException("Não existem tickets a serem mostrados!");
            }
            for (Ticket ticket: listaAuxiliar) {
                if(ticket.getModulo().getId() == idModulo){
                    listaTicketsModulo.add(ticket);
                }
            }
            if(listaTicketsModulo.isEmpty()){
                throw new IllegalArgumentException("Não existem tickets deste moódulo a serem mostrados!");
            }
            return  listaTicketsModulo;


        }catch (IllegalArgumentException e){
            return  listaTicketsModulo;
        }

    }

    public String salvar(TicketDTO ticketDTO) throws ParseException {
        try{
            Ticket ticket = new Ticket();

            SimpleDateFormat  formater = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            Date dataAtual = calendar.getTime();
            ticket.dataAbertura = Util.formater.parse(formater.format(dataAtual)); ;
            if(ticketDTO.titulo.isEmpty()){
                throw new IllegalArgumentException("Título deve ser preenhcido");
            }
            ticket.titulo = ticketDTO.titulo;
            Cliente cliente = clienteService.findById(ticketDTO.getIdCliente());

            ticket.cliente = cliente;

            Modulo modulo = moduloService.findById(ticketDTO.getIdModulo());
            ticket.modulo = modulo;
            repository.save(ticket);
            return "Ticket Código: "+ticket.getId().toString()+" Salvo com sucesso";
        }catch (IllegalArgumentException e ){
            return e.getMessage();
        }

    }
}
