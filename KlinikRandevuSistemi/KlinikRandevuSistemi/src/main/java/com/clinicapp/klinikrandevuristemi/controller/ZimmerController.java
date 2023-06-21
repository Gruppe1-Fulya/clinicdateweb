package com.clinicapp.klinikrandevuristemi.controller;

import com.clinicapp.klinikrandevuristemi.model.*;
import com.clinicapp.klinikrandevuristemi.service.ZimmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;




import java.util.List;

@Controller
@RequestMapping("/zimmer")
public class ZimmerController {

    private ZimmerService zimmerService;

    @Autowired
    public void setZimmerService(ZimmerService zimmerService){
        this.zimmerService=zimmerService;
    }

    @RequestMapping(value="/zimmer/get")
    public String getAllZimmer(ModelMap modelMap){
        List<Zimmer> zimmerList = zimmerService.findAll();
        modelMap.addAttribute("zimmerlist",zimmerList);
        return "zimmer/zimmer";
    }
}
