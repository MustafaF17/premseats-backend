package com.example.PremSeats.controller;

import com.example.PremSeats.model.Fixture;
import com.example.PremSeats.model.Team;
import com.example.PremSeats.model.Ticket;
import com.example.PremSeats.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    private final TicketService ticketService;
    public TicketController(TicketService ticketService) {this.ticketService = ticketService;}

    //Get all tickets
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketService.findAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    //Get all users tickets
    @GetMapping("/mytickets/{id}")
    public List<Ticket> getAllUsersTickets(@PathVariable("id") Long id){
        List<Ticket> tickets = ticketService.findTicketByuserid(id);
        return tickets;
    }

    @PostMapping("/add")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        Ticket newTicket = ticketService.addTicket(ticket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }

    //Delete specific ticket
    @Transactional
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
