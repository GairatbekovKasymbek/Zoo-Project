package org.example.Service;

import org.example.DAO.UserDAO;
import org.example.Model.User;
import org.example.DatabaseConnection;

import java.sql.SQLException;

public class AuthService {
    private final UserDAO userDAO;

    public AuthService() throws SQLException {
        // Получаем подключение к БД
        this.userDAO = new UserDAO(DatabaseConnection.getConnection());
    }

    public User login(String username, String password) {
        // Проверяем логин и пароль
        if (userDAO.checkLogin(username, password)) {
            // Если успех — возвращаем объект User
            return userDAO.getUserByUsername(username);
        }
        // Если не найден — возвращаем null
        return null;
    }
}
