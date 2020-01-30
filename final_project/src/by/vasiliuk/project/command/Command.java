package by.vasiliuk.project.command;

import by.vasiliuk.project.service.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws CommandException, ServiceException;
}