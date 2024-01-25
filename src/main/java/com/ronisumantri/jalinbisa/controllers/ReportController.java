package com.ronisumantri.jalinbisa.controllers;

import com.ronisumantri.jalinbisa.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    ReportServices reportServices;

    @GetMapping("/print")
    public String processFile(){
        ReportServices.processFile();
        return "Print report";
    }

}
