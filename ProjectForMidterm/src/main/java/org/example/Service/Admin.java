package org.example.Service;

import org.example.DAO.animalDAO;
import org.example.DAO.TicketDAO;
import org.example.Model.Animal;

import java.time.LocalDate;


public class Admin {
    private final animalDAO animalDAO = new animalDAO();
    private final TicketDAO ticketDAO = new TicketDAO();

    public void addAnimal(String name, String species, String desc, int Quatity) {
        animalDAO.addAnimal(new Animal(0, name, species, desc, Quatity));
    }

    public void removeAnimal(int id) {
        animalDAO.removeAnimal(id);
    }

    public void addTicket(LocalDate date, double price) {
        ticketDAO.addTicket(price, date);
    }
}