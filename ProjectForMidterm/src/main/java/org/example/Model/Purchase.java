package org.example.Model;

import java.time.LocalDateTime;

public class Purchase {
    private int id;
    private int userId;
    private int ticketId;
    private double totalPrice;
    private LocalDateTime purchaseDate;

    public Purchase() {}

    public Purchase(int id, int userId, int ticketId, double totalPrice, LocalDateTime purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.ticketId = ticketId;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
    }

    public Purchase(int userId, int ticketId, double totalPrice, LocalDateTime purchaseDate) {
        this.userId = userId;
        this.ticketId = ticketId;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
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

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", userId=" + userId +
                ", ticketId=" + ticketId +
                ", totalPrice=" + totalPrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
