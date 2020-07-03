package pl.bartdel.quotesbasespring.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bartdel.quotesbasespring.dao.entity.User;
import pl.bartdel.quotesbasespring.dao.service.UserService;
import pl.bartdel.quotesbasespring.validation.UserValidator;

@Controller
@RequestMapping
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount
            (@ModelAttribute(value ="newUser") User newUser, BindingResult bindingResult) {
        userValidator.validate(newUser, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
         userService.registerNewUserAccount(newUser);

        return "redirect:/loginNewUser";
    }
}
