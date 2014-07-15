package TestBash.dao;

import TestBash.domain.Messages;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Эмиль on 09.07.2014.
 */
@Repository
public class MessagesDAOImpl  implements MessagesDAO  {

    @Autowired
    private SessionFactory sessionFactory;



    public void addMessage(Messages message) {
        sessionFactory.getCurrentSession().save(message);
    }

    @SuppressWarnings("unchecked")
    public List<Messages> listMessages() {
        return sessionFactory.getCurrentSession().createQuery("from TestBash.domain.Messages").list();
    }
}
