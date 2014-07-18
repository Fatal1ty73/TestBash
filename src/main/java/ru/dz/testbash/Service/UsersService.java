package ru.dz.testbash.Service;

import ru.dz.testbash.domain.Users;

import java.util.List;

/**
 * Created by Эмиль on 16.07.2014.
 */
public interface UsersService {

    public int addUser(Users users);

    public List<Users> listUsers();
}
