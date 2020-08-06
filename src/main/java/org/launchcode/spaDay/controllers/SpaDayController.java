package org.launchcode.spaDay.controllers;

import org.launchcode.spaDay.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class SpaDayController {

    @GetMapping
    public String displayClientForm (Model model) {
        model.addAttribute("title", "Client Form");
        return "serviceSelection";
    }

    @PostMapping
    public String processClientForm(@RequestParam String skintype, @RequestParam String manipedi, Model model) {
        Client newClient = new Client(skintype, manipedi);
        newClient.setAppropriateFacials(skintype);
        model.addAttribute("client" , newClient);

        return "menu";
    }
}
