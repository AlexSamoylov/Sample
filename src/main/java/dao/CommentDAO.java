package dao;

import domain.Comment;

import java.util.List;

/**
 * Created by Alexey Samoylov on 14.01.2015.
 */
public interface CommentDAO {
    public void addComment(Comment comment);

    public List<Comment> listComment();

    public void removeComment(Integer id);

    public Integer getID(Comment comment);
}
