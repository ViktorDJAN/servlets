package org.example.command.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.RedirectResult;
import org.example.result.Result;

import java.util.concurrent.TimeUnit;

import static org.example.Resources.*;

public class AuthorizationCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("nameInput");
        String loginValue = request.getParameter("loginInput");
        String passwordValue = request.getParameter("passwordInput");
        System.out.println(userName);
        System.out.println(loginValue);
        System.out.println(passwordValue);
        HttpSession session = request.getSession(true);

        if (checkUserLogin(loginValue)) {
            String message = "Entered login already exists";
            System.out.println(message);
            session.setAttribute("message1", message);
            return new RedirectResult(COMMAND_SHOW_AUTHORIZATION_PAGE);
        }
        if (userName == null) {
            String message = "User cannot be without a name";
            session.setAttribute("message2", message);
            return new RedirectResult(COMMAND_SHOW_AUTHORIZATION_PAGE);
        } else {
            User newOneUser = new User();
            newOneUser.setName(userName);
            newOneUser.setLogin(loginValue);
            newOneUser.setPassword(passwordValue);
            newOneUser.setUserType(UserType.CLIENT);
            DataBase.USERS.add(newOneUser);
            if (checkUserLogin(loginValue)) {
                String message = "New user successfully registered";
                session.setAttribute("message3", message);
                delay();
            }
        }
        return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);

    }

    public boolean checkUserLogin(String login) {
        for (User user : DataBase.USERS) {
            if (user.getLogin().equals(login))
                return true;
        }
        return false;
    }
    public void delay(){
        long time = 1;
        TimeUnit time1 = TimeUnit.SECONDS;
        try{
            time1.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
