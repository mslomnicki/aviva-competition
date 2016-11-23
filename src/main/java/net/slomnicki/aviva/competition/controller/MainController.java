package net.slomnicki.aviva.competition.controller;

import net.slomnicki.aviva.competition.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Rootpage controller
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String showIndex() {
        return "redirect:/clients";
    }
}
