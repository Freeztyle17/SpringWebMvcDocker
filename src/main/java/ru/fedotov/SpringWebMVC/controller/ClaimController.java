package ru.fedotov.SpringWebMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fedotov.SpringWebMVC.model.Claim;
import ru.fedotov.SpringWebMVC.model.ClaimInfo;
import ru.fedotov.SpringWebMVC.service.ClaimService;


import java.util.Date;


@Controller
@RequestMapping("/api/claim")
public class ClaimController {

    @Autowired
    ClaimService cs;

    @GetMapping("/claims")
    public String getUsers(Model model) {

        model.addAttribute("Claims", cs.getAllClaims());

        return "Claim";
    }

    @GetMapping("/newClaim")
    public String newClaim(Model model) {

        model.addAttribute("claimInfo", new ClaimInfo());

        return "CreateClaim";
    }

    @PostMapping("/createNewClaim")
    public String create(@RequestParam("provider_id") long provider_id,
                         @RequestParam("delivery_or_refund") String delivery_or_refund,
                         @RequestParam("comment") String comment,
                         Model model){

        Date dateNow = new Date();
        long id = cs.getAllClaims().size() + 1;
        ClaimInfo claim = new ClaimInfo();


        claim.setDate_of_claim(dateNow);
        claim.setStatus("Открыто");
        claim.setId(id);

        claim.setProvider_id(provider_id);
        claim.setDelivery_or_refund(delivery_or_refund);
        claim.setComment(comment);

        model.addAttribute("claimInfo", cs.createClaim(claim));

        return "redirect:/api/claim/claims";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") long id){

        model.addAttribute("claim", cs.find(id));

        return "ClaimStatusEdit";
    }

    @PutMapping("update/{id}")
    public String update(@ModelAttribute("claim") Claim claim, @PathVariable("id") long id){

        cs.update(id, claim);

        return "redirect:/api/claim/claims";
    }


    //    @GetMapping("/claims")
    //    public String Invoice(Model model) {
    //        model.addAttribute("Claims", cs.getAllClaims());
    //        return "Claim";
    //    }


}
