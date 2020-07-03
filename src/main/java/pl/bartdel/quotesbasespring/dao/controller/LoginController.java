package pl.bartdel.quotesbasespring.dao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/loginNewUser")
    public String showNewUserLoginForm(Model model) {
        model.addAttribute("newUserLogin", true);
        return "login";
    }

    @RequestMapping(value = "/login")
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
