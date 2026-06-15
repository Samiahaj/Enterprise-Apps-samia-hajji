package be.enterpriseapps.ngoapp.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import be.enterpriseapps.ngoapp.service.EventService;
import be.enterpriseapps.ngoapp.model.Event;
import org.springframework.web.bind.annotation.PathVariable;
import be.enterpriseapps.ngoapp.model.Event;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import be.enterpriseapps.ngoapp.model.ContactForm;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class HomeController {

    private final EventService eventService;

    public HomeController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("events", eventService.getEvents());

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model){

        model.addAttribute("contactForm", new ContactForm());

        return "contact";

    }

    @GetMapping("/new")
    public String newEvent(Model model) {

        model.addAttribute("event", new Event());

        return "new";
    }

    @PostMapping("/new")
    public String saveEvent(
            @Valid Event event,
            BindingResult bindingResult,
            @RequestParam("file") MultipartFile file,
            Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("event", event);

            return "new";
        }
        if(!file.isEmpty()){

            try{

                String fileName = file.getOriginalFilename();

                Path uploadPath = Paths.get(
                        "src/main/resources/static/images"
                );

                if(!Files.exists(uploadPath)){
                    Files.createDirectories(uploadPath);
                }

                Files.copy(
                        file.getInputStream(),
                        uploadPath.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING
                );

                event.setImage(fileName);

            }catch(Exception e){

                e.printStackTrace();

            }

        }
        eventService.addEvent(event);

        return "redirect:/?success";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        Event event = eventService.getEventById(id);

        model.addAttribute("event", event);

        return "details";
    }
    @GetMapping("/delete/{id}")
    public String deleteEvent(
            @PathVariable Long id){

        eventService.deleteEvent(id);

        return "redirect:/";
    }
}