package org.example.command;

import org.example.result.Result;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Command {
    Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
