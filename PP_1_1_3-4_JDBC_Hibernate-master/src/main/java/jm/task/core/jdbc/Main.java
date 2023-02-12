package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
       //User user = new User("Ivan", "Mrrrr", (byte)23);
        List<User> users = new ArrayList<>();
       userService.createUsersTable();
       userService.saveUser("Ivan", "Mr", (byte)21);
       userService.saveUser("Ivan", "Mrr", (byte)22);
       userService.saveUser("Ivan", "Mrrr", (byte)23);
       userService.saveUser("Ivan", "Mrrrr", (byte)24);
        users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
