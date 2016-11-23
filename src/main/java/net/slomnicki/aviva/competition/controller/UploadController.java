package net.slomnicki.aviva.competition.controller;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.FlashMessage;
import net.slomnicki.aviva.competition.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * File upload controller
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    private ClientService service;

    @Autowired
    public UploadController(ClientService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showUploadForm() {
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam MultipartFile file,
                             RedirectAttributes redirectAttributes) {
        // Show error if not XML file
        if (!file.getContentType().equals("text/xml")) {
            redirectAttributes.addFlashAttribute("flash", new FlashMessage(FlashMessage.Status.FAILURE, "Błędny typ pliku"));
            return "redirect:/upload";
        }
        try {
            // Try to parse and save file in database
            service.saveXmlFileToDatabase(file);
        } catch (XmlParseException e) {
            redirectAttributes.addFlashAttribute("flash", new FlashMessage(FlashMessage.Status.FAILURE, "Błąd przetwarzania (" + e.getMessage() + ")"));
            return "redirect:/upload";
        }
        redirectAttributes.addFlashAttribute("flash", new FlashMessage(FlashMessage.Status.SUCCESS, "Import pliku zakończony powodzeniem"));
        return "redirect:/";
    }
}
