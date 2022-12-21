package com.example.PremSeats.repo;
import com.example.PremSeats.model.Ticket;
import com.example.PremSeats.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {


    void deleteTicketById(Long id);

    List<Ticket> findAllByUserid(Long id);
}
