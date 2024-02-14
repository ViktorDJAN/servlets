package org.example.data;

import java.util.List;
import java.util.Optional;

public interface DateBaseFunctions {
    List<User> findAll();
    Optional<User> findByLogin(String login);
    boolean createUser(User user);
}
