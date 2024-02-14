package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataBase implements DateBaseFunctions{

    public final static List<User> USERS = new ArrayList<>();
    static {
        USERS.add(new User("qwer","qwer","John",UserType.CLIENT,false));
        USERS.add(new User("rewq","rewq","Bob",UserType.CLIENT,false));
        USERS.add(new User("admin","admin","Admin",UserType.ADMIN,false));
    }
    public DataBase() {
    }

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }


    @Override
    public List<User> findAll() {
            return USERS;
        }


    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User>foundUser = Optional.of(new User());
        for(User user : USERS){
            if(user.getLogin().equals(login))
                foundUser = Optional.of(user);
        }
        return foundUser;
    }

    @Override
    public boolean createUser(User user) {
        if(user==null){
            return false;
        }
        return USERS.add(user);
    }
}
