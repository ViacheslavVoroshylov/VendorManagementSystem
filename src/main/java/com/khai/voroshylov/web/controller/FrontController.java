package com.khai.voroshylov.web.controller;

import com.khai.voroshylov.command.Command;
import com.khai.voroshylov.command.factory.CommandFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    //public static final String VIEW_FILE_EXTENSION = ".jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = handleRequest(req, resp);
        req.getRequestDispatcher(forward).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = handleRequest(req, resp);
        resp.sendRedirect(req.getContextPath() + redirect);
    }

    private String handleRequest(HttpServletRequest req, HttpServletResponse resp){
        Command command = CommandFactory.getCommand(req);

        return command.execute(req, resp);
    }
}
