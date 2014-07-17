package ru.dz.testbash.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("users") Users users, @ModelAttribute("text") String text, @ModelAttribute("usernick") String usernick,
                             BindingResult result) {

        System.out.println("Text: " + text + ", usernick: " + users.getNickname() + ", users: " + users);
        if(users.getNickname().length()<3) {
            System.err.println("Is empty");
        } else {
            //usersService.addUser(users);
        }

        return "redirect:/index";
    }

}
