package com.nowweareowner.nowweareowner.impl;


import com.nowweareowner.nowweareowner.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    List<User> users = new ArrayList<>();


    public void addUser(User user) {
        users.add(user);
    }

    public void loadUsersFromFile(String fileName) {
        List<User> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userValues = line.split(",");
                if (userValues.length == 4) {
                    int id = Integer.parseInt(userValues[0]);
                    String name = userValues[1];
                    String lastName = userValues[2];
                    String secondName = userValues[3];

                    User user = new User(id, name, lastName, secondName);
                    userList.add(user);
                }
            }

            System.out.println("Пользователи успешно загружены из файла.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public void addUserToFile(String fileName, User user) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
                String line = user.getId() + "," + user.getName() + "," + user.getLastName() + "," + user.getSecondName();
                bw.write(line);
                bw.newLine();

            System.out.println("Пользователь успешно добавлены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

    }



        public void addUsersToFile(String fileName, List<User> userList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (User user : userList) {
                String line = user.getId() + "," +  user.getName() + "," + user.getLastName() + "," + user.getSecondName();
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Пользователи успешно добавлены в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }


    public void sort() {
        Collections.sort(users, User::compareTo);
    }

    public List<User> getUsers() {
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
