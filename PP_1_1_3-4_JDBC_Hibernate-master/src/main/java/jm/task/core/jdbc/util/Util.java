package jm.task.core.jdbc.util;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import java.io.IOException;

public class Util {
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://localhost:3306/userabc";
        String username = "root";
        String password = "Password";
        return (Connection) DriverManager.getConnection(url, username, password);
    }
}
