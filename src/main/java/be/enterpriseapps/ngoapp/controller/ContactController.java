package be.enterpriseapps.ngoapp.controller;

import be.enterpriseapps.ngoapp.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
public class ContactController {
    @Autowired
    private JavaMailSender mailSender;



    @PostMapping("/contact")
    public String sendMail(
            @Valid @ModelAttribute ContactForm contactForm,
            BindingResult bindingResult,
            Model model) {

        if(bindingResult.hasErrors()){

            model.addAttribute("contactForm", contactForm);

            return "contact";
        }

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("info@ngo.be");

        message.setSubject("Nieuw bericht");

        message.setText(
                "Naam : " + contactForm.getNaam()
                        + "\nEmail : " + contactForm.getEmail()
                        + "\n\nBericht :\n"
                        + contactForm.getBericht()
        );

        mailSender.send(message);

        return "redirect:/contact?success";
    }
}
