package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserServiceImpl userService = new UserServiceImpl(); // создал экземпляр класса UserServiceImpl,реализующий интерфейс userService
        userService.createUsersTable(); // создание таблицы User-ов, если ее нет

        try {   // в блок try добавлены 4 user-а с помощью метода saveUser

            userService.saveUser("Ivan", "Petrov", (byte) 30);
            userService.saveUser("Petr", "Ivanov",(byte) 25);
            userService.saveUser("Anna", "Gennadievna", (byte) 28);
            userService.saveUser("Maria", "Olegovna", (byte) 22);


            System.out.println("Список пользователей:");
            userService.getAllUsers().forEach(System.out::println);  //  вызван метод getAllUsers() возвращающий список всех пользователей,
            //  и метод for each с лямбдой выражения который выводит всех пользователей в консоль

        } finally {
            userService.cleanUsersTable(); // очищение таблицы от всех записей
        }
    }
}