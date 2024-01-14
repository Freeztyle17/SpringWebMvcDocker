package ru.fedotov.SpringWebMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/about")
public class AboutController {
    @GetMapping("/aboutClaims")
    public String aboutClaims() {

        return "AboutClaim";
    }

    @GetMapping("/aboutInvoices")
    public String aboutInvoices() {

        return "AboutInvoices";
    }
}
