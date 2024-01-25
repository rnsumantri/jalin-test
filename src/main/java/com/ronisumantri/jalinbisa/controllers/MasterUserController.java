package com.ronisumantri.jalinbisa.controllers;

import com.ronisumantri.jalinbisa.dto.GetAllUsers;
import com.ronisumantri.jalinbisa.entity.MasterRole;
import com.ronisumantri.jalinbisa.entity.MasterUsers;
import com.ronisumantri.jalinbisa.services.MasterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insert")
    public String saveUsers(@RequestBody MasterUsers masterUsers){
        MasterUsers newMasterUser = masterUserService.insertMasterUser(masterUsers);
        System.out.printf("\nID : %d",newMasterUser.getId());
        System.out.printf("\nName : %s",newMasterUser.getName());
        return "Insert Master User";
    }
}
