package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookTherapyMVC {

	@GetMapping("/login")
    public String showLoginPage() {
        return "login"; // carica login.html
    }

    @GetMapping("/registrati")
    public String showRegisterPage() {
        return "registrati"; // carica registrati.html
    }
}
