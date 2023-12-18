package com.khai.voroshylov.command.factory;

import com.khai.voroshylov.command.Command;
import com.khai.voroshylov.command.CommandEnum;

import javax.servlet.http.HttpServletRequest;

public final class CommandFactory {

    private CommandFactory() {

    }

    public static Command getCommand(HttpServletRequest req){
        String paramCommand = req.getParameter("command");
        Command command = null;

        if(paramCommand != null) {


            try {
                command = CommandEnum.valueOf(paramCommand).getCommand();

            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid command: " + paramCommand);
                System.out.println(exception.getMessage());
                command = CommandEnum.ERROR_PAGE.getCommand();
            }
        }
        else {
            command = CommandEnum.ERROR_PAGE.getCommand();
        }
        return command;
    }
}
