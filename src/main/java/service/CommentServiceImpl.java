package service;

import domain.Comment;
import dao.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Alexey Samoylov on 14.01.2015.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;

    @Transactional
    @Override
    public void addComment(Comment comment) {
    commentDAO.addComment(comment);
    }

    @Transactional
    @Override
    public List<Comment> listComment() {
        return commentDAO.listComment();
    }

    @Transactional
    @Override
    public void removeComment(Integer id) {
        commentDAO.removeComment(id);
    }

    @Transactional
    @Override
    public Integer getID(Comment comment) {
        return commentDAO.getID(comment);
    }
}
