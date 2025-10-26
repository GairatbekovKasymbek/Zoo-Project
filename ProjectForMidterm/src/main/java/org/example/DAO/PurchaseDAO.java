package org.example.DAO;

import org.example.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PurchaseDAO {

    // 💳 Покупка билета
    public void buyTicket(int userId, int ticketId) {
        String sql = "INSERT INTO purchases (user_id, ticket_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, ticketId);
            ps.executeUpdate();

            System.out.println("✅ Ticket purchased successfully!");
        } catch (Exception e) {
            System.out.println("❌ Error purchasing ticket: " + e.getMessage());
        }
    }
}
