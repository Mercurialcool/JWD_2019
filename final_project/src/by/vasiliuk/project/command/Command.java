package main.java.by.vasiliuk.command;

import main.java.by.vasiliuk.dao.DaoException;
import main.java.by.vasiliuk.service.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws DaoException, ServiceException;
}