package ru.dz.testbash.dao;

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


    public void addUser(Users users) {
        sessionFactory.getCurrentSession().save(users);

    }

    @SuppressWarnings("unchecked")
    public List<Users> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from ru.dz.testbash.domain.Users").list();
    }


}
