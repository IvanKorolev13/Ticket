package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 1500, "DME", "KZN", 105);
    Ticket ticket2 = new Ticket(2, 25000, "DME", "NCE", 240);
    @Test
    public void toRemove(){
        repo.save(ticket1);
        repo.save(ticket2);
        repo.removeById(1);

        Ticket[] expected = {ticket2};
        Ticket[] actual = repo.inputAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void toRemoveNoExistTicket(){
        repo.save(ticket1);
        repo.save(ticket2);
        repo.removeById(3);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.inputAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}