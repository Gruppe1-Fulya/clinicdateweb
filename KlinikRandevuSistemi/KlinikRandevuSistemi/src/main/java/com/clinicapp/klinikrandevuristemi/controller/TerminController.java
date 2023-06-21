package com.clinicapp.klinikrandevuristemi.controller;

import com.clinicapp.klinikrandevuristemi.model.*;
import com.clinicapp.klinikrandevuristemi.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/termin")
public class TerminController {

    private TerminService terminService;

    @Autowired
    public TerminController(TerminService terminService){
        this.terminService=terminService;
    }

    @RequestMapping(value= "/add", method = RequestMethod.GET)
    public String TerminHinzufugenPage(@ModelAttribute("termin") Termin termin, ModelMap modelMap){
        return "termin/add";
    }

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String TerminHinzufugen(@ModelAttribute("termin") Termin termin, RedirectAttributes redirectAttributes){
        terminService.saveTermin(termin);
        redirectAttributes.addFlashAttribute("termin",termin);
        return "redirect:/termin/add";
    }

    @RequestMapping(value= "/update/{ID}", method=RequestMethod.GET)
    public String TerminAnzeigenPage(@PathVariable Long ID, ModelMap modelMap, RedirectAttributes redirectAttributes){
        Optional<Termin> optionalTermin = terminService.findTerminByID(ID);
        if(optionalTermin.isPresent()){
            Termin termin = optionalTermin.get();
            modelMap.addAttribute("termin", termin);
            return "termin/update";
        }
        redirectAttributes.addFlashAttribute("NichtGefunden","Ups!!Etwas bei der Aktualisierung des Termin-Informationen Schiff gegangen.");
        return "redirect:/termin/update";
    }

    @RequestMapping(value = "/update/{ID}", method = RequestMethod.POST)
    public String TerminAnzeigen(@ModelAttribute Termin termin ,@PathVariable Long ID , RedirectAttributes redirectAttributes){
        terminService.updateTermin(termin);
        redirectAttributes.addFlashAttribute("successfullyUpdatedTermin","Der Termin-Informationen sind aktualisiert.");
        return "redirect:/termin/update";
    }
}
