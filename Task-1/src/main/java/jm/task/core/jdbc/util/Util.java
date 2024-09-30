package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";    // константы
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Lilo626";

    private static SessionFactory sessionFactory;    // создание сессий Hibernate

    public static Connection getConnection() {        //Метод для получения соединения с базой данных с использованием JDBC.
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);   // Возвращает соединение с базой данных, используя URL, имя пользователя и пароль.
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к базе данных", e);
        }
    }

    public static SessionFactory getSessionFactory() {  // получения фабрики сессий Hibernate
        if (sessionFactory == null) {  //проверка на создании фабрики сессий
            try {
                Configuration configuration = new Configuration()   // создание объекта конфигурации Hibernate
                        .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")    // свойства конфигурации
                        .setProperty("hibernate.connection.url", URL)
                        .setProperty("hibernate.connection.username", USERNAME)
                        .setProperty("hibernate.connection.password", PASSWORD)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                        .setProperty("hibernate.hbm2ddl.auto", "update")
                        .addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();  // Создает и возвращает фабрику сессий.
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка создания фабрики сессий");
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}