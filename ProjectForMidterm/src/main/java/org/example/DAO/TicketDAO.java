package org.example.DAO;

import org.example.DatabaseConnection;
import org.example.Model.Ticket;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    // Добавление билета в базу
    public void addTicket(double price, LocalDate visitDate) {
        String sql = "INSERT INTO tickets (date, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(visitDate));
            ps.setDouble(2, price);
            ps.executeUpdate();
            System.out.println("✅ Ticket added to database.");
        } catch (SQLException e) {
            System.out.println("❌ Error adding ticket: " + e.getMessage());
        }
    }

    // Получить все билеты из базы
    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("id"),
                        0,                                  // userId (по умолчанию)
                        0,                                  // animalId (по умолчанию)
                        rs.getDouble("price"),
                        rs.getDate("date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching tickets: " + e.getMessage());
        }
        return tickets;
    }

    // Получить билет по ID из базы
    public Ticket getTicketById(int id) {
        String sql = "SELECT * FROM tickets WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Ticket(
                        rs.getInt("id"),
                        0,                                  // userId
                        0,                                  // animalId
                        rs.getDouble("price"),
                        rs.getDate("date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching ticket: " + e.getMessage());
        }
        return null;
    }

    // Удалить билет
    public void removeTicket(int id) {
        String sql = "DELETE FROM tickets WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Ticket deleted with ID: " + id);
        } catch (SQLException e) {
            System.out.println("❌ Error deleting ticket: " + e.getMessage());
        }
    }
}
