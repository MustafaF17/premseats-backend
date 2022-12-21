package com.example.PremSeats.service;

import com.example.PremSeats.model.Ticket;
import com.example.PremSeats.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepo ticketRepo;

    @Autowired
    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    //Add ticket
    public Ticket addTicket(Ticket ticket){
        return ticketRepo.save(ticket);
    }

    //Find all tickets
    public List<Ticket> findAllTickets(){
        return ticketRepo.findAll();
    }

    //Find by id of user logged in
    public List<Ticket> findTicketByuserid(Long id) {
        return ticketRepo.findAllByUserid(id);
    }

    public void deleteTicket(Long id){
        ticketRepo.deleteTicketById(id);
    }

}
