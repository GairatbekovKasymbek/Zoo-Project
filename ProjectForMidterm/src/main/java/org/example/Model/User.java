package org.example.Model;

import org.example.DAO.animalDAO;
import org.example.DAO.PurchaseDAO;
import org.example.DAO.TicketDAO;
import org.example.DAO.UserDAO;
import org.example.Model.Animal;
import org.example.Model.Purchase;
import org.example.Model.Ticket;
import org.example.Main;
import org.example.DatabaseConnection;

import java.util.List;


public class User{
    private int id;
    private String name;
    private String password;
    private String Role;

    public User(int id, String name, String password, String Role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.Role = Role;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return Role;
    }
    public void setRole(String role) {
        Role = role;
    }
}

