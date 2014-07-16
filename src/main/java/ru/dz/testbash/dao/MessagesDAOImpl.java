package ru.dz.testbash.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.testbash.domain.Messages;

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
    public List<Object[]> listMessages() {
        // TODO rewrite in criteria API
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Messages.class);
        criteria.addOrder(Order.desc("dateAddMess"));
/*
        criteria.createAlias("employee.address", "address"); // inner join by default

        ProjectionList columns = Projections.projectionList()
                .add(Projections.property("name"))
                .add(Projections.property("address.city"));
        criteria.setProjection(columns);*/

        List<Object[]> list = criteria.list();

        return list;
    }
}
