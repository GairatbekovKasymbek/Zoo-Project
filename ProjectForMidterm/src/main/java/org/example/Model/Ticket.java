package org.example.Model;

import org.example.Model.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.example.DAO.animalDAO;


import java.time.LocalDate;

public class Ticket {
    private int id;
    private int userId;
    private int animalId;
    private double price;
    private LocalDate visitDate;


    public Ticket(int id, int userId, int animalId, double price, LocalDate visitDate) {
        this.id = id;
        this.userId = userId;
        this.animalId = animalId;
        this.price = price;
        this.visitDate = visitDate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + userId +
                ", animalId=" + animalId +
                ", price=" + price +
                ", visitDate=" + visitDate +
                '}';
    }
}

