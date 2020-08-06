package org.launchcode.spaDay.controllers;

import org.launchcode.spaDay.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        String name = "User " + user.getUsername();
        model.addAttribute("name", name);
        if(verify.equals(user.getPassword())) {
            return "user/index";
        } else {
            model.addAttribute("error", "Password is not verified");
            return "user/add";
        }
    }
 }
