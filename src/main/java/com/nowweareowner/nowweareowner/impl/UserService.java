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
    private List<User> users = new ArrayList<>();
    private long userId =1L;


    public void showUsers(String result) {
        if (result.equalsIgnoreCase("list")) {
            System.out.println("Список пользователей:");
            List<User> userList = readUsersFromFile("users.txt");
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
    public List<User> readUsersFromFile(String fileName) {
        List<User> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userValues = line.split(",");
                if (userValues.length == 4) {
                    Long userId = Long.parseLong(userValues[0]);
                    String name = userValues[1];
                    String lastName = userValues[2];
                    String secondName = userValues[3];

                    User user = new User(userId, name, lastName, secondName);
                    userList.add(user);
                }
            }
            System.out.println("Пользователи успешно загружены из файла.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return userList;
    }
//TODO настроить присвоение id пользователю, тогда должно работать
    public void addUser(String result) {
        try {
            String[] parts = result.split(" ");
            if (parts.length != 3) {
                throw new IllegalAccessException("Некорректный формат, введите пользователя еще раз");
            }
            String name = parts[0];
            String lastName = parts[1];
            String secondName = parts[2];

            User newUser = new User(userId, name, lastName, secondName);
            users.add(newUser);
            userId++;

            addUserToFile("users.txt", newUser);

            System.out.println("Пользователь успешно добавлен.");
        } catch (IllegalAccessException e) {
            System.out.println("Пользователь не добавлен");
        }
    }

    private void addUserToFile(String fileName, User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            String line = user.getUserId() + "," + user.getName() + "," + user.getLastName() + "," + user.getSecondName();
            bw.write(line);
            bw.newLine();

            System.out.println("Записанно в файл");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}



//    public void sort() {
//        Collections.sort(users, User::compareTo);
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }


//    public void userCommunication(User currentUser, User otherUser) {
//        Scanner scanner = new Scanner(System.in);
//        String message;
//
//        while (true) {
//            System.out.print(currentUser.getName() + ": ");
//            message = scanner.nextLine();
//
//            if (message.equalsIgnoreCase("exit")) {
//                System.out.println("Chat ended.");
//                break;
//            }
//
//            System.out.println(otherUser.getName() + ": " + message);
//        }
//
//        scanner.close();
//    }
//
//}

