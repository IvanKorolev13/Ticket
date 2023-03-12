package ru.netology.ticket;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }
    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repo.inputAll()) {
            if ((item.getFrom() == from) && (item.getTo() == to)) {
                result = repo.saveResult(result, item);
            }
        }
        Arrays.sort(result);
        return result;
    }

}
