package ru.dz.testbash.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dz.testbash.domain.Users;

import java.util.List;

/**
 * Created by Эмиль on 16.07.2014.
 */
@Repository
public class UsersDAOimpl implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;



    public int addUser(Users users) {
        sessionFactory.getCurrentSession().save(users);
        sessionFactory.getCurrentSession().flush();

        return users.getId();
    }

    @SuppressWarnings("unchecked")
    public List<Users> listUsers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Users.class);
        List<Users> list = criteria.list();


        return list;
    }



}
