package ru.dz.testbash.web;

import ru.dz.testbash.Service.MessagesService;
import ru.dz.testbash.domain.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Эмиль on 11.07.2014.
 */

@Controller
public class SiteController {

    @Autowired
    private MessagesService messagesService;




    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {

        map.put("message", new Messages());
        map.put("messageList", messagesService.listMessages());
        map.put("messageUser","Vasya");

        return "start";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }



}