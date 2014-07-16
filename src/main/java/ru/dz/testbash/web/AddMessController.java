package ru.dz.testbash.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dz.testbash.Service.UsersService;
import ru.dz.testbash.domain.Users;

import java.util.Map;

/**
 * Created by Эмиль on 15.07.2014.
 */
@Controller
public class AddMessController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/addmess")
    public String listUsers(Map<String, Object> map) {

        map.put("users", new Users());
        map.put("usersList", usersService.listUsers());

        return "addmess";
    }

   /* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("messagess") Messages messages,
                             BindingResult result) {

        messagesService.addMessage(messages);

        return "redirect:/index";
    }
*/
}
