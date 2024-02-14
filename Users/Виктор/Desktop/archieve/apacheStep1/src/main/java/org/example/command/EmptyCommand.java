package org.example.command;

import org.example.result.ForwardResult;
import org.example.result.Result;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.example.Resources.PAGE_CHAT;

public class EmptyCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        return new ForwardResult(PAGE_CHAT);
    }
}
