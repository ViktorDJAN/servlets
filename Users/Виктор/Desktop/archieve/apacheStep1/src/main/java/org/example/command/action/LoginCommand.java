package org.example.command.action;

import jakarta.servlet.http.HttpSession;
import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.example.Resources.*;
import static org.example.data.DataBase.USERS;

public class LoginCommand implements Command {

    // Ваша реализация выполнения входа в Чат
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String loginValue = request.getParameter("loginInput");
        String passwordValue = request.getParameter("passwordInput");
        User foundUser = new User();
        DataBase dataBase = new DataBase();
        if(loginValue.equals("admin")&&checkUser(loginValue,passwordValue)){
            foundUser = dataBase.findByLogin(loginValue).get();
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("foundUser",foundUser); // key / value
            foundUser.setOnline(true);
            return new RedirectResult(COMMAND_SHOW_ADMIN_PAGE);

        }
        if(checkUser(loginValue,passwordValue)){
            foundUser = dataBase.findByLogin(loginValue).get();
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("foundUser",foundUser); // key / value
            foundUser.setOnline(true);
            System.out.println(USERS);
            System.out.println("here we are");
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        }



         else {
            foundUser.setOnline(false);
            request.getSession().setAttribute("error","Incorrect password");
            return new RedirectResult(COMMAND_SHOW_AUTHORIZATION_PAGE);
        }

    }

    public boolean checkUser(String login, String password){
        for( User user: DataBase.USERS){
            if(user.getLogin().equals(login)&& user.getPassword().equals(password))
                return true;
        }
        return false;
    }

}
