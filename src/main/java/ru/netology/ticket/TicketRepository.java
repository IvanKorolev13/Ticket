package ru.netology.ticket;

import java.util.Comparator;

public class TicketRepository {
    Ticket[] ticket = new Ticket[0];

    public void save(Ticket newItem) {
        Ticket[] tmp = new Ticket[ticket.length + 1];
        for (int i = 0; i < ticket.length; i++) {
            tmp[i] = ticket[i];
        }
        tmp[tmp.length - 1] = newItem;
        ticket = tmp;
    }
    public Ticket findById(int id) {
        for (Ticket item : inputAll()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public void removeById(int id) {
        if(findById(id) != null){
            Ticket[] tmp = new Ticket[ticket.length - 1];
            int copyToIndex = 0;
            for (int i = 0; i < ticket.length; i++) {
                if (ticket[i].getId() != id) {
                    tmp[copyToIndex] = ticket[i];
                    copyToIndex++;
                }
            }
            ticket = tmp;
        }
    }
    public Ticket[] saveResult(Ticket[] result, Ticket newItem) {
        Ticket[] tmp = new Ticket[result.length + 1];
        for (int i = 0; i < result.length; i++) {
            tmp[i] = result[i];
        }
        tmp[tmp.length - 1] = newItem;
        return tmp;
    }

    public Ticket[] inputAll() {
        return ticket;
    }
}
