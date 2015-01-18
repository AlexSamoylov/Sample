package dao;

import java.util.List;

import domain.Comment;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexey Samoylov on 14.01.2015.
 */

@Repository
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addComment(Comment comment) {
        sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public List<Comment> listComment() {
        return sessionFactory.getCurrentSession().createQuery("from  Comment ").list();
    }

    @Override
    public void removeComment(Integer id) {
        Comment comment = (Comment) sessionFactory.getCurrentSession().load(
                Comment.class, id);
        if (comment != null) {
            sessionFactory.getCurrentSession().delete(comment);
        }
    }

    public Integer getID(Comment comment) {
        String hql = "Select C.id FROM Comment C WHERE C.name = :com_name";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("com_name",comment.getName());
        return (Integer)query.list().get(0);
    }

//    private static CommentDAOImpl ourInstance = new CommentDAOImpl();
//
//    public static CommentDAOImpl getInstance() {
//        return ourInstance;
//    }
//
//    private CommentDAOImpl() {
//    }
}
