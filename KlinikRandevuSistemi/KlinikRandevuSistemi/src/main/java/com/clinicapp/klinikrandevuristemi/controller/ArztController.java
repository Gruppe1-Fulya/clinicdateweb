package com.clinicapp.klinikrandevuristemi.controller;

import com.clinicapp.klinikrandevuristemi.model.*;
import com.clinicapp.klinikrandevuristemi.service.ArztService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;




import java.util.List;


@Controller
@RequestMapping("/arzt")
public class ArztController {

    private ArztService arztService;

    @Autowired
    public void setArztService(ArztService arztService){
        this.arztService=arztService;
    }

    @RequestMapping("/arzt")
    public String getAllArzt(ModelMap modelMap){
        List<Arzt> arztList= arztService.findAll();
        modelMap.addAttribute("arztlist",arztList);
        return "arzt/arzt";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String setArzt(@ModelAttribute List<Arzt> arztList){
        arztService.addMultipleArzte((List<Arzt>) arztList);
        return null;
    }
}
