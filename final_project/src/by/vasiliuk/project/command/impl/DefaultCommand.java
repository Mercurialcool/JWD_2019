package by.vasiliuk.project.command.impl;

import by.vasiliuk.project.command.Command;
import by.vasiliuk.project.command.CommandException;
import by.vasiliuk.project.command.JspPath;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return JspPath.INDEX;
    }
}
