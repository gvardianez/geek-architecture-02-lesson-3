package ru.geekbrains.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private Connection connection;

    public Main() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5434/postgres", "postgres", "postgres");
            Statement statement = connection.createStatement();
            statement.execute("drop table users");
            statement.execute("create table users (id bigserial primary key, username varchar(36) not null unique, password varchar(80) not null);"
            );
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Mapper<User> mapper = new UserMapper(main.connection);
        Repository<User> users = new Repository<>(mapper);
        User user1 = new User("hgfbg", "hibjrtgiohjb");
        user1 = users.insert(user1).orElseThrow(RuntimeException::new);
        System.out.println(user1);
        user1.setLogin("sasasas");
        users.update(user1);
        System.out.println(users.findByString("sasasas"));
        users.beginTransaction();
        for (int i = 0; i < 10; i++) {
            users.insert(new User("sfgsdf"+ i, i + "ihguiohjgfiob"));
        }
        users.commitTransaction();
        users.beginTransaction();
        for (int i = 0; i < 10; i++) {
            users.insert(new User("rererer"+ i, i + "ihguiohjgfiob"));
            if (i == 4) users.rollbackTransaction();
        }
        users.commitTransaction();
    users.delete(user1);
    }


}
