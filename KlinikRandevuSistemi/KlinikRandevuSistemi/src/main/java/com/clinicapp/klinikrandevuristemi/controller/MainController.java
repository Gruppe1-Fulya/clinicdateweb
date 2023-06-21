package com.clinicapp.klinikrandevuristemi.controller;


import com.clinicapp.klinikrandevuristemi.service.ArztService;
import com.clinicapp.klinikrandevuristemi.service.KundenService;
import com.clinicapp.klinikrandevuristemi.service.TerminService;
import com.clinicapp.klinikrandevuristemi.service.ZimmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private KundenService kundenService;
    private TerminService terminService;
    private ArztService arztService;
    private ZimmerService zimmerService;

    @Autowired
    public MainController(KundenService kundenService, TerminService terminService, ArztService arztService, ZimmerService zimmerService) {
        this.kundenService = kundenService;
        this.terminService = terminService;
        this.arztService = arztService;
        this.zimmerService = zimmerService;
    }

    @RequestMapping(value = {"/","/index","/index.html"}, method = RequestMethod.GET)
    public ModelAndView indexPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
