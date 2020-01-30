package by.vasiliuk.project.dao;

import by.vasiliuk.project.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> findAllByAdvertId(long id) throws DaoException;
}
