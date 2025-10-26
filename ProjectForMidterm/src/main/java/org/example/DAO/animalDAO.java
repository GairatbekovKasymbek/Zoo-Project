package org.example.DAO;

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

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class animalDAO {

    // Добавить животное
    public void addAnimal(Animal animal) {
        String sql = "INSERT INTO animals (name, species, description, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, animal.getName());
            ps.setString(2, animal.getSpecies());
            ps.setString(3, animal.getDescription());
            ps.setInt(4, animal.getQuantity());

            ps.executeUpdate();
            System.out.println("✅ Animal added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error adding animal: " + e.getMessage());
        }
    }

    // Удалить животное по ID
    public void removeAnimal(int id) {
        String sql = "DELETE FROM animals WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("🗑️ Animal deleted successfully!");
            else
                System.out.println("⚠️ Animal not found!");
        } catch (SQLException e) {
            System.out.println("❌ Error deleting animal: " + e.getMessage());
        }
    }

    // Обновить данные животного
    public void updateAnimal(Animal animal) {
        String sql = "UPDATE animals SET name = ?, species = ?, description = ?, quantity = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, animal.getName());
            ps.setString(2, animal.getSpecies());
            ps.setString(3, animal.getDescription());
            ps.setInt(4, animal.getQuantity());
            ps.setInt(5, animal.getId());

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("🦁 Animal updated successfully!");
            else
                System.out.println("⚠️ Animal not found!");
        } catch (SQLException e) {
            System.out.println("❌ Error updating animal: " + e.getMessage());
        }
    }

    // Получить список всех животных
    public List<Animal> getAllAnimals() {
        List<Animal> list = new ArrayList<>();
        String sql = "SELECT * FROM animals ORDER BY id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Animal animal = new Animal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getString("description"),
                        rs.getInt("quantity")
                );
                list.add(animal);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error reading animals: " + e.getMessage());
        }
        return list;
    }

    // Получить одно животное по ID
    public Animal getAnimalById(int id) {
        String sql = "SELECT * FROM animals WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Animal(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getString("description"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            System.out.println("❌ Error finding animal: " + e.getMessage());
        }
        return null;
    }

    // Подсчитать общее количество животных (всех вместе)
    public int countTotalAnimals() {
        String sql = "SELECT SUM(quantity) AS total FROM animals";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next())
                return rs.getInt("total");
        } catch (SQLException e) {
            System.out.println("❌ Error counting animals: " + e.getMessage());
        }
        return 0;
    }
}
