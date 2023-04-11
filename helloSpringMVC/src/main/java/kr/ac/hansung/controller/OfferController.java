package kr.ac.hansung.controller;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OfferController {

    // controller -> service -> dao
    // controller -> model -> view

    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public  String showOffers(Model model) {

        List<Offer> offers = offerService.getCurrent();
        model.addAttribute("id_offers", offers);

        return "offers";
    }

    @GetMapping("/createoffer")
    public String createOffer(Model model) {

        model.addAttribute("offer", new Offer());

        return "createoffer";

    }

    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("=== Form data does not validated ===");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error: errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer";
        }

        //System.out.println(offer);

        offerService.insert(offer);

        return "offercreated";
    }
}
