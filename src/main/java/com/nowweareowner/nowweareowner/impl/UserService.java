package com.nowweareowner.nowweareowner.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.nowweareowner.nowweareowner.models.User;

public class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addUsersToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (User user : users) {
                writer.write(user.getName() + "," + user.getLastName() + "," + user.getSecondName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> loadUsersFromFile(String filePath) {
        List<User> loadedUsers = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    String name = userData[0].trim();
                    String lastName = userData[1].trim();
                    String secondName = userData[2].trim();
                    User user = new User(name, lastName, secondName);
                    loadedUsers.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedUsers;
    }

    public void sort() {
        // Implement your sorting logic here
    }
}
