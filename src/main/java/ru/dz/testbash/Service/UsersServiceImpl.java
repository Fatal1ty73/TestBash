package ru.dz.testbash.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.testbash.dao.UsersDAO;
import ru.dz.testbash.domain.Users;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Эмиль on 16.07.2014.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Transactional
    public void addUser(Users users) {
        usersDAO.addUser(users);
    }

    @Transactional
    public List<Users> listUsers() {
        return usersDAO.listUsers();
    }
}
