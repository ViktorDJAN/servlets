package org.example.command.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.command.Command;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import java.util.*;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class ChatSendMessageCommand implements Command {

    private ArrayList<User> userMessagesBuffer = new ArrayList<>();

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession(true);
        response.setIntHeader("Refresh", 3);

        var param1 = request.getParameter("inputField");
        User user = (User) httpSession.getAttribute("foundUser");
        User userTempo = new User(user.getLogin(), user.getPassword(), user.getName(), user.getUserType(),user.isBlocked());

        String message;
        if (userTempo.isBlocked()) {
            System.out.println(userTempo.isBlocked() + " chat msg");
            message="disabled";
            httpSession.setAttribute("block", message);
        }
        else{
            httpSession.getAttribute("block");
            message="";
            httpSession.setAttribute("block", message);
        }
        if (param1 == null) {
            param1 = "";
            userTempo.setMessage(param1);
            addUserToList(userTempo);
            userMessagesBuffer.remove(userMessagesBuffer.size() - 1);
        } else {
            userTempo.setMessage(param1);
            addUserToList(userTempo);

        }


        request.setAttribute("users", userMessagesBuffer);
        request.setAttribute("users", userMessagesBuffer);

        return new ForwardResult(COMMAND_SHOW_CHAT_PAGE);
    }

    public void addUserToList(User user) {
        userMessagesBuffer.add(user);
    }
}
