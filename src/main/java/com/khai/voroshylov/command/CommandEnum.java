package com.khai.voroshylov.command;

import com.khai.voroshylov.get.CustomerPageCommand;
import com.khai.voroshylov.get.ErrorPageCommand;
import com.khai.voroshylov.get.HomePageCommand;
import com.khai.voroshylov.get.VendorPageCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageCommand()),
    CUSTOMER_PAGE(new CustomerPageCommand()),
    ERROR_PAGE(new ErrorPageCommand()),
    VENDOR_PAGE(new VendorPageCommand());

    private Command command;

    CommandEnum (Command command){
        this.command = command;

    }

    public Command getCommand() {
        return command;
    }
}
