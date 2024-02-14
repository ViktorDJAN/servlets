package org.example.command.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import java.io.IOException;
import java.io.PrintWriter;

import static org.example.Resources.COMMAND_SHOW_ADMIN_PAGE;

public class BanUserByAdminCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        DataBase dataBase = new DataBase();
        HttpSession session = request.getSession(true);
        request.setAttribute("dbusers",dataBase.USERS);
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        User foundUser = new User();
        String[]chosenCheckBoxes = request.getParameterValues("checkboxName");
        for(String item: chosenCheckBoxes){
            if(dataBase.findByLogin(item).isPresent()){
                System.out.println(item + " selected one");
                foundUser = dataBase.findByLogin(item).get();
                System.out.println("found uset is ==" + foundUser.getName());
                foundUser.setBlocked(true);
                System.out.println(foundUser.isBlocked());
                String message="disabled";
                session.setAttribute("block", message);
            }
        }






        System.out.println("hehe checkbox here");
        return new RedirectResult(COMMAND_SHOW_ADMIN_PAGE);
    }
}
