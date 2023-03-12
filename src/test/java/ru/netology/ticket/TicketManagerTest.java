package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 1500, "DME", "KZN", 105);
    Ticket ticket2 = new Ticket(2, 25000, "DME", "NCE", 240);
    Ticket ticket3 = new Ticket(3, 15000, "DME", "KZN", 140);
    Ticket ticket4 = new Ticket(4, 2100, "NBC", "DME", 105);
    Ticket ticket5 = new Ticket(5, 3500, "DME", "KZN", 90);
    Ticket ticket6 = new Ticket(6, 2700, "DME", "KZN", 95);
    Ticket ticket7 = new Ticket(7, 21000, "DME", "NCE", 290);
    Ticket ticket8 = new Ticket(8, 1500, "DME", "KZN", 110);

    @BeforeEach
    public void setup(){
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
    }
    @Test
    public void toFindNoExistTicket(){
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("NBC", "NCE");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void toFindOneExistTicket(){
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("NBC", "DME");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void toFindFewExistTicket(){
        Ticket[] expected = {ticket1, ticket8, ticket6, ticket5, ticket3};
        Ticket[] actual = manager.findAll("DME", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }
}