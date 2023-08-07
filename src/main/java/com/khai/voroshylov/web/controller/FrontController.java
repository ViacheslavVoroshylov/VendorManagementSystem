package com.khai.voroshylov.web.controller;

import com.khai.voroshylov.command.Command;
import com.khai.voroshylov.get.ErrorPageCommand;
import com.khai.voroshylov.get.HomePageCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    public static final String VIEW_FILE_EXTENSION = ".jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String forward = handleRequest(req, resp);
        req.getRequestDispatcher(forward + VIEW_FILE_EXTENSION).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = handleRequest(req, resp);
        resp.sendRedirect(redirect);
    }

    private String handleRequest(HttpServletRequest req, HttpServletResponse resp){

        String paramCommand = req.getParameter("command");
        Command command;
        if("HOME_PAGE".equals(paramCommand)){
            command = new HomePageCommand();
        } else {
            command = new ErrorPageCommand();
        }
        return command.execute(req, resp);
    }
}
