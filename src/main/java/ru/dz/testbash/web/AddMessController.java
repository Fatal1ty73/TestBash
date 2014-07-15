package ru.dz.testbash.web;

import ru.dz.testbash.Service.MessagesService;
import ru.dz.testbash.domain.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Эмиль on 15.07.2014.
 */
@Controller
public class AddMessController {

    @Autowired
    private MessagesService messagesService;

    @RequestMapping("/addmess")
    public String showAddingPage() {
        return "addmess";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("messagess") Messages messages,
                             BindingResult result) {

        messagesService.addMessage(messages);

        return "redirect:/index";
    }

}
