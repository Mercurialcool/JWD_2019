package main.java.by.vasiliuk.dao;

import main.java.by.vasiliuk.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getAllByAdvertId(long id);
}
