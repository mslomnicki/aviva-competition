package net.slomnicki.aviva.competition.controller;

import net.slomnicki.aviva.competition.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller that controls all client related pages
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Controller
@RequestMapping("/clients")
public class ClientController {
    public ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @RequestMapping
    public String getAllClients(Model model) {
        model.addAttribute("clients", service.findAll());
        return "clients";
    }

    @RequestMapping("/{id}")
    public String getClientDetails(@PathVariable Long id, Model model) {
        model.addAttribute("client", service.findOne(id));
        return "details";
    }
}
