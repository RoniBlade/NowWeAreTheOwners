package com.nowweareowner.nowweareowner.impl;

import com.nowweareowner.nowweareowner.models.User;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    int id = 0;
    UserService userService;

    public UserInterface(UserService userService) {
        this.userService = userService;
    }

    Scanner scanner = new Scanner(System.in);

    // TODO: 15.07.2023 Сделать метод в UserService, который будет печатать пользователей и использовать его тут
    public void userInput(){
        int userId = id++;
        System.out.println("Имя: ");
        String name = scanner.nextLine();
        System.out.println("Фамилия: ");
        String lastName = scanner.nextLine();
        System.out.println("Отчество: ");
        String secondName = scanner.nextLine();

        User user = new User(userId, name, lastName, secondName);
        userService.addUser(user);
        userService.addUserToFile("users.txt", user);

        System.out.println("Добавлено имя: " + user);

        userService.loadUsersFromFile("users.txt");
        List<User> loadedUsers = userService.getUsers();
        System.out.println("Обновленный список пользователей:");

        for (User loadedUser : loadedUsers) {
            System.out.println("Данные: " + loadedUser.getName() + " " + loadedUser.getLastName() + " " + loadedUser.getSecondName() + "\n");
        }

    }

    // TODO: 15.07.2023 Придумать как исправить этот костыль(если делать сканер внутри метода, то при повторном вызове метода из main вылетает ошибка)
    public void closeScan() {
        if (scanner != null)
            scanner.close();
    }

}
