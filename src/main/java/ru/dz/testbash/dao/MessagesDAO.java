package ru.dz.testbash.dao;

import ru.dz.testbash.domain.Messages;

import java.util.List;

/**
 * Created by Эмиль on 09.07.2014.
 */

public interface MessagesDAO {

    public void addMessage(Messages message);

    public List listMessages();
}
