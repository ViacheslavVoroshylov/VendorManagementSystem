package com.khai.voroshylov.get;

import com.khai.voroshylov.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "view/HomePage";
    }
}
