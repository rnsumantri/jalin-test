package com.ronisumantri.jalinbisa.controllers;

import com.ronisumantri.jalinbisa.dto.GetAllUsers;
import com.ronisumantri.jalinbisa.services.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MasterUserController {
    @Autowired
    MasterUserService masterUserService;

    @GetMapping("/list-all")
    public List<GetAllUsers> getAllUsersList(){
        return masterUserService.getAllUsersList();
    }
}
