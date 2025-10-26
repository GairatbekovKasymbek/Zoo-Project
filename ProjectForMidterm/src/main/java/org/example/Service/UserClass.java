package org.example.Service;

import org.example.DAO.TicketDAO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import org.example.DAO.animalDAO;
import org.example.DAO.PurchaseDAO;
import org.example.DAO.TicketDAO;
import org.example.DAO.UserDAO;
import org.example.Model.Animal;
import org.example.Model.Purchase;
import org.example.Model.Ticket;
import org.example.Model.User;
import org.example.Main;
import org.example.DatabaseConnection;
import org.example.Service.AuthService;
import org.example.Service.UserClass;
import org.example.Service.Admin;

import java.time.LocalDate;
import java.util.Scanner;

import static javax.management.remote.JMXConnectorFactory.connect;


public class UserClass {
    private final animalDAO animalDAO;
    private final TicketDAO ticketDAO;
    private final PurchaseDAO purchaseDAO;
    private final Scanner scanner;
    private final Object connection;

    public UserClass() {
        this.connection = DatabaseConnection.getConnection();
        this.animalDAO = new animalDAO();
        this.ticketDAO = new TicketDAO();
        this.purchaseDAO = new PurchaseDAO();
        this.scanner = new Scanner(System.in);
    }

    public void viewAnimals() {
        System.out.println("\n=== 🐾 Animals in Zoo ===");
        List<Animal> animals = animalDAO.getAllAnimals();
        if (animals.isEmpty()) {
            System.out.println("No animals available.");
        } else {
            for (Animal a : animals) {
                System.out.println(a);
            }
        }
    }

    // 🔹 Просмотр доступных билетов
    public void viewTickets() {
        System.out.println("\n=== 🎟️ Available Tickets ===");
        List<Ticket> tickets = ticketDAO.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
        } else {
            for (Ticket t : tickets) {
                System.out.println(t);
            }
        }
    }

    // 🔹 Купить билет
    public void buyTicket(int userId, int ticketId) {
        System.out.println("\n=== 💰 Buying Ticket ===");

        // Проверяем, существует ли билет
        Ticket ticket = ticketDAO.getTicketById(ticketId);
        if (ticket == null) {
            System.out.println("❌ Ticket not found!");
            return;
        }

        // Покупаем билет (запись в базу)
        purchaseDAO.buyTicket(userId, ticketId);

        System.out.println("✅ Ticket purchased successfully!");
    }

}
