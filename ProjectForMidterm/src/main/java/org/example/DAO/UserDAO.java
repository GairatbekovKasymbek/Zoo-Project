package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


public class UserDAO {

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    // 🔹 Добавить нового пользователя
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.executeUpdate();
            System.out.println("✅ User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Найти пользователя по имени
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 🔹 Получить всех пользователей
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // 🔹 Обновить данные пользователя
    public void updateUser(User user) {
        String sql = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getId());
            stmt.executeUpdate();
            System.out.println("✅ User updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Удалить пользователя по ID
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ User deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Проверка логина (авторизация)
    public boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // если есть строка — логин успешен
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeUser(int id) {
    }
}

