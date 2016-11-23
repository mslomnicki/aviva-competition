package net.slomnicki.aviva.competition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Rootpage controller
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String showIndex() {
        return "redirect:/clients";
    }
}
