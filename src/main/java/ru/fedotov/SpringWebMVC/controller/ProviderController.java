package ru.fedotov.SpringWebMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fedotov.SpringWebMVC.model.Provider;
import ru.fedotov.SpringWebMVC.service.ProviderService;

@Controller
@RequestMapping("/api/provider")
public class ProviderController {

    @Autowired
    ProviderService a;

    @GetMapping("/providers")
    public String Providers(Model model){

        model.addAttribute("Providers", a.getAllProviders());

        return "Providers";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") long id){

        model.addAttribute("provider", a.find(id));

        return "ProviderCommentEdit";
    }

    @PutMapping("update/{id}")
    public String update(@ModelAttribute("provider") Provider provider, @PathVariable("id") long id){

        a.update(id, provider);

        return "redirect:/api/provider/providers";
    }

}
