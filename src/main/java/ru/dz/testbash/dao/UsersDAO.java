package ru.dz.testbash.dao;

import ru.dz.testbash.domain.Users;

import java.util.List;

/**
 * Created by Эмиль on 16.07.2014.
 */
public interface UsersDAO {
    public void addUser(Users users);

    public List<Users> listUsers();
}
