package com.nowweareowner.nowweareowner.impl;


import com.nowweareowner.nowweareowner.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class UserService {

    List<String> users;


    public void addUser(String user) {
        users.add(user);
    }

    public void addUsersToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String user : users) {
                writer.write(user);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsersFromFile(String fileName) {
        List<String> loadedUsers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedUsers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        users.addAll(loadedUsers);
    }

    public void sort() {
        Collections.sort(users);
    }

    public List<String> getUsers() {
        return users;
    }

    public void userCommunication(User currentUser, User otherUser) {
        Scanner scanner = new Scanner(System.in);
        String message;

        while (true) {
            System.out.print(currentUser.getName() + ": ");
            message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Chat ended.");
                break;
            }

            System.out.println(otherUser.getName() + ": " + message);
        }

        scanner.close();
    }

}
