package ru.dz.testbash.Service;

import ru.dz.testbash.domain.Messages;

import java.util.List;

/**
 * Created by Эмиль on 09.07.2014.
 */

public interface MessagesService {

    public void addMessage(Messages message);

    public List listMessages();
}
