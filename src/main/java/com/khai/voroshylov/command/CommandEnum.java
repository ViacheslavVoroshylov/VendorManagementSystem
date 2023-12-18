package com.khai.voroshylov.command;

import com.khai.voroshylov.get.CustomerPageCommand;
import com.khai.voroshylov.get.ErrorPageCommand;
import com.khai.voroshylov.get.HomePageCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageCommand()),
    CUSTOMER_PAGE(new CustomerPageCommand()),
    ERROR_PAGE(new ErrorPageCommand());

    private Command command;

    CommandEnum (Command command){
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }
}
