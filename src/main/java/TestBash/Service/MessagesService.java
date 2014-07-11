package TestBash.Service;

import TestBash.domain.Messages;

import java.util.List;

/**
 * Created by Эмиль on 09.07.2014.
 */

public interface MessagesService {

    public void addMessage(Messages message);

    public List<Messages> listMessages();
}
