package com.nowweareowner.nowweareowner.impl;

import com.nowweareowner.nowweareowner.models.User;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public void UserInput(){
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Имя: ");
        String name1 = scanner.nextLine();
        System.out.println("Фамилия: ");
        String name2 = scanner.nextLine();
        System.out.println("Отчество: ");
        String name3 = scanner.nextLine();

        User user = new User(name1, name2, name3);
        userService.addUser(user);
        userService.addUsersToFile("users.txt");

        scanner.close();

        System.out.println("Добавлено имя: " + user);

        List<User> loadedUsers = userService.loadUsersFromFile("users.txt");
        System.out.println("Обновленный список пользователей:");

        for (User loadedUser : loadedUsers) {
            System.out.println("Имя: " + loadedUser.getName() + " " + loadedUser.getLastName() + " " + loadedUser.getSecondName() + "\n");
        }
        System.exit(0);
    }

}
