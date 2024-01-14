package ru.fedotov.SpringWebMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fedotov.SpringWebMVC.service.ReceiptService;

@Controller
@RequestMapping("/api/receipt")
public class ReceiptController {
    @Autowired
    ReceiptService cs;

    @GetMapping("/receipts")
    public String Receipt(Model model){

        model.addAttribute("Receipts", cs.getAllChecks());

        return "Receipts";
    }

    @GetMapping("/receiptStory")
    public String ReceiptStory(Model model, @RequestParam("id") long id){

        model.addAttribute("ReceiptStory", cs.getAllReceiptsById(id));

        return "receiptStory";
    }
}
