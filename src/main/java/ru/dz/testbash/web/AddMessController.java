package ru.dz.testbash.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.dz.testbash.Service.MessagesService;
import ru.dz.testbash.Service.UsersService;
import ru.dz.testbash.domain.Messages;
import ru.dz.testbash.domain.Users;

import java.util.Date;
import java.util.Map;

/**
 * Created by Эмиль on 15.07.2014.
 */
@Controller
public class AddMessController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private MessagesService messagesService;

    @RequestMapping("/addmess")
    public String listUsers(@ModelAttribute("selectedUser") Users user, Map<String, Object> map) {

        map.put("users", new Users());
        map.put("usersList", usersService.listUsers());

        return "addmess";
    }

   @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("sendMessage") Users users, @ModelAttribute("text") String text,
                             BindingResult result) {
       text =text.replaceAll("\\n","<br>");
       int userid=users.getId();

       Messages message=new Messages();

        if(users.getNickname().length()<3) {
            System.err.println("Is empty");
        } else {
            if(userid==0) {

                Users usersNew = new Users();
                usersNew.setId(usersService.addUser(users));
                message.setUsers(usersNew);
            }
            else
            {
                Users usersNew = new Users();
                usersNew.setId(userid);
                message.setUsers(usersNew);

            }
        }
       message.setText(text);
       message.setdateAddMess(new Date());




       System.out.println(message.getText()+" "+message.getdateAddMess()+" "+message.getUsers().getId());
       messagesService.addMessage(message);

        return "redirect:/index";
    }

}
