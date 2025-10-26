package org.example;

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

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = auth.login(username, password);

        if (user == null) {
            System.out.println("Invalid login!");
            return;
        }

        switch (user.getRole()) {
            case "admin" -> {
                Admin admin = new Admin();
                while (true) {
                    System.out.println("\n=== Admin Menu ===");
                    System.out.println("1. Add Animal");
                    System.out.println("2. Remove Animal");
                    System.out.println("3. Add Ticket");
                    System.out.println("4. Exit");
                    System.out.print("Choose: ");
                    int c = sc.nextInt(); sc.nextLine();

                    switch (c) {
                        case 1 -> {
                            System.out.print("Name: "); String name = sc.nextLine();
                            System.out.print("Species: "); String species = sc.nextLine();
                            System.out.print("Description: "); String desc = sc.nextLine();
                            System.out.print("Quantity: "); int quantity = sc.nextInt(); sc.nextLine();
                            admin.addAnimal(name, species, desc, quantity);
                        }
                        case 2 -> {
                            System.out.print("Animal ID: "); int id = sc.nextInt();
                            admin.removeAnimal(id);
                        }
                        case 3 -> {
                            System.out.print("Ticket date (yyyy-mm-dd): ");
                            LocalDate date = LocalDate.parse(sc.nextLine());
                            System.out.print("Price: "); double price = sc.nextDouble();
                            admin.addTicket(date, price);
                        }
                        case 4 -> {
                            System.out.println("Goodbye, Admin!");
                            return;
                        }
                        default -> System.out.println("Invalid choice!");
                    }
                }
            }

            case "user" -> {
                UserClass us = new UserClass();
                while (true) {
                    System.out.println("\n=== User Menu ===");
                    System.out.println("1. View Animals");
                    System.out.println("2. View Tickets");
                    System.out.println("3. Buy Ticket");
                    System.out.println("4. Exit");
                    System.out.print("Choose: ");
                    int c = sc.nextInt(); sc.nextLine();

                    switch (c) {
                        case 1 -> us.viewAnimals();
                        case 2 -> us.viewTickets();
                        case 3 -> {
                            System.out.print("Ticket ID: ");
                            int ticketId = sc.nextInt();
                            us.buyTicket(user.getId(), ticketId);
                        }
                        case 4 -> {
                            System.out.println("Goodbye, User!");
                            return;
                        }
                        default -> System.out.println("Invalid choice!");
                    }
                }
            }

            default -> System.out.println("Unknown role! Contact administrator.");
        }
    }
}