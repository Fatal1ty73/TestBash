package TestBash.Service;

import TestBash.dao.MessagesDAO;
import TestBash.domain.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Эмиль on 09.07.2014.
 */

@Service("messagesService")
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesDAO messageDAO;


    @Transactional
    public void addMessage(Messages message) {
        messageDAO.addMessage(message);

    }

    @Transactional
    public List<Messages> listMessages() {
        return messageDAO.listMessages();
    }
}
