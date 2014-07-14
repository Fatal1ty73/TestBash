package TestBash.web;

import TestBash.Service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Эмиль on 11.07.2014.
 */

@Controller
public class SiteController {

    @Autowired
    private MessagesService contactService;

    @RequestMapping("/index")
    public String listContacts() {
        return "start";
    }


   /* @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {

        map.put("message", new Messages());
        map.put("messageList", contactService.listMessages());

        return "start";
    }*/

    @RequestMapping("/")
    public String home() {
        return "start";
    }

   /* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("message") Messages messages,
                             BindingResult result) {

        contactService.addMessage(messages);

        return "redirect:/index";
    }*/

}