package com.nowweareowner.nowweareowner.impl;

import java.util.Scanner;

public class UserInterface {
    UserService userService;
    public UserInterface(UserService userService) {
        this.userService = userService;
    }
    public void userInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите: Имя Фамилию Отчество . . .(через пробел и без запятых). . .");
            System.out.println("Вы можете так же ввести - list , для просмотра списка");
            System.out.println("Для выхода - exit");
            String result = scanner.nextLine();

            closeScan(result);

            userService.showUsers(result);

            try {
                userService.addUser(result);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeScan(String result) {
        if (result.equalsIgnoreCase("exit")) {
            System.out.println("Программа завершена");
            System.exit(0);
        }
    }
}
// TODO: 15.07.2023 Сделать метод в UserService, который будет печатать пользователей и использовать его тут
