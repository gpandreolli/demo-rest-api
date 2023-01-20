package com.gpa.demorestapi.repository;

import com.gpa.demorestapi.dto.TicketDTO;
import com.gpa.demorestapi.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    @Query(" from Ticket t where t.dataAbertura BETWEEN :dataInicial AND :dataFinal ")
    public List<Ticket> findAllbyMonthAndYear(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

}
